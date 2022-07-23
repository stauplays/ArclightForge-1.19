package net.verox.arclight.entity.mob.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

public class AngelEntity extends FlyingMob implements IAnimatable, Enemy {

    public int getInvulnerableTicks() {
        return this.entityData.get(DATA_ID_INV);
    }

    public void setInvulnerableTicks(int p_31511_) {
        this.entityData.set(DATA_ID_INV, p_31511_);
    }

    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(WitherBoss.class, EntityDataSerializers.INT);
    private static final int INVULNERABLE_TICKS = 220;
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);


    public static final float FLAP_DEGREES_PER_TICK = 7.448451F;
    public static final int TICKS_PER_FLAP = Mth.ceil(24.166098F);
    private static final EntityDataAccessor<Integer> ID_SIZE = SynchedEntityData.defineId(AngelEntity.class, EntityDataSerializers.INT);
    Vec3 moveTargetPoint = Vec3.ZERO;
    BlockPos anchorPoint = BlockPos.ZERO;
    AngelEntity.AttackPhase attackPhase = AngelEntity.AttackPhase.CIRCLE;

    private AnimationFactory factory = new AnimationFactory(this);

    public AngelEntity(EntityType<? extends FlyingMob> entityType, Level level) {
        super(entityType, level);
        this.setHealth(this.getMaxHealth());
        this.xpReward = 5;
        this.moveControl = new AngelEntity.AngelMoveControl(this);
        this.lookControl = new AngelEntity.AngelLookControl(this);
    }

    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        this.setInvulnerableTicks(p_31474_.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }

    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        this.bossEvent.setName(this.getDisplayName());
    }

    public static AttributeSupplier setAttributes() {
        return FlyingMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 500.0D)
                .add(Attributes.ATTACK_DAMAGE, 65.0f)
                .add(Attributes.ATTACK_SPEED, 3.0f)
                .add(Attributes.MOVEMENT_SPEED, 3.0f).build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AngelEntity.AngelAttackStrategyGoal());
        this.goalSelector.addGoal(2, new AngelEntity.AngelSweepAttackGoal());
        this.goalSelector.addGoal(3, new AngelEntity.AngelCircleAroundAnchorGoal());
        this.targetSelector.addGoal(1, new AngelEntity.AngelAttackPlayerTargetGoal());
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
    }

    public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
        return null;
    }

    public boolean isFlapping() {
        return (this.getUniqueFlapTickOffset() + this.tickCount) % TICKS_PER_FLAP == 0;
    }

    protected BodyRotationControl createBodyControl() {
        return new AngelEntity.AngelBodyRotationControl(this);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("move", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_SIZE, 2);
    }

    public void setAngelSize(int p_33109_) {
        this.entityData.set(ID_SIZE, Mth.clamp(p_33109_, 0, 64));
    }

    private void updateAngelSizeInfo() {
        this.refreshDimensions();
        //this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((double)(6 + this.getAngelSize()));
    }

    public int getAngelSize() {
        return this.entityData.get(ID_SIZE);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_33134_) {
        if (ID_SIZE.equals(p_33134_)) {
            this.updateAngelSizeInfo();
        }

        super.onSyncedDataUpdated(p_33134_);
    }

    public int getUniqueFlapTickOffset() {
        return this.getId() * 3;
    }

    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

    protected float getStandingEyeHeight(Pose p_33136_, EntityDimensions p_33137_) {
        return p_33137_.height * 0.35F;
    }

    public void tick() {
        super.tick();
        if (this.level.isClientSide) {
            float f = Mth.cos((float)(this.getUniqueFlapTickOffset() + this.tickCount) * 7.448451F * ((float)Math.PI / 180F) + (float)Math.PI);
            float f1 = Mth.cos((float)(this.getUniqueFlapTickOffset() + this.tickCount + 1) * 7.448451F * ((float)Math.PI / 180F) + (float)Math.PI);
            if (f > 0.0F && f1 <= 0.0F) {
                this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENDER_DRAGON_FLAP, this.getSoundSource(), 0.95F + this.random.nextFloat() * 0.05F, 0.95F + this.random.nextFloat() * 0.05F, false);
            }

            int i = this.getAngelSize();
            float f2 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * (0.6F + 0.21F * (float)i);
            float f3 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) * (0.6F + 0.21F * (float)i);
            float f4 = (0.3F + f * 0.45F) * ((float)i * 0.2F + 1.0F);
            this.level.addParticle(ParticleTypes.FIREWORK, this.getX() + (double)f2, this.getY() + (double)f4, this.getZ() + (double)f3, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.FIREWORK, this.getX() - (double)f2, this.getY() + (double)f4, this.getZ() - (double)f3, 0.0D, 0.0D, 0.0D);
        }

    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33126_, DifficultyInstance p_33127_, MobSpawnType p_33128_, @Nullable SpawnGroupData p_33129_, @Nullable CompoundTag p_33130_) {
        this.anchorPoint = this.blockPosition().above(5);
        this.setAngelSize(3);
        return super.finalizeSpawn(p_33126_, p_33127_, p_33128_, p_33129_, p_33130_);
    }

    public void addAdditionalSaveData(CompoundTag p_33141_) {
        super.addAdditionalSaveData(p_33141_);
        p_33141_.putInt("AX", this.anchorPoint.getX());
        p_33141_.putInt("AY", this.anchorPoint.getY());
        p_33141_.putInt("AZ", this.anchorPoint.getZ());
        p_33141_.putInt("Size", this.getAngelSize());
    }

    public boolean shouldRenderAtSqrDistance(double p_33107_) {
        return true;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENDER_DRAGON_FLAP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.WITHER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.WITHER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.WITHER_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }

    public boolean canAttackType(EntityType<?> p_33111_) {
        return true;
    }

    public EntityDimensions getDimensions(Pose p_33113_) {
        int i = this.getAngelSize();
        EntityDimensions entitydimensions = super.getDimensions(p_33113_);
        float f = (entitydimensions.width + 4.2F * (float)i) / entitydimensions.width;
        return entitydimensions.scale(f);
    }

    static enum AttackPhase {
        CIRCLE,
        SWOOP;
    }

    class AngelAttackPlayerTargetGoal extends Goal {
        private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(64.0D);
        private int nextScanTick = reducedTickDelay(20);

        public boolean canUse() {
            if (this.nextScanTick > 0) {
                --this.nextScanTick;
                return false;
            } else {
                this.nextScanTick = reducedTickDelay(60);
                List<Player> list = AngelEntity.this.level.getNearbyPlayers(this.attackTargeting, AngelEntity.this, AngelEntity.this.getBoundingBox().inflate(16.0D, 64.0D, 16.0D));
                if (!list.isEmpty()) {
                    list.sort(Comparator.<Entity, Double>comparing(Entity::getY).reversed());

                    for(Player player : list) {
                        if (AngelEntity.this.canAttack(player, TargetingConditions.DEFAULT)) {
                            AngelEntity.this.setTarget(player);
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = AngelEntity.this.getTarget();
            return livingentity != null ? AngelEntity.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
        }
    }

    class AngelAttackStrategyGoal extends Goal {
        private int nextSweepTick;

        public boolean canUse() {
            LivingEntity livingentity = AngelEntity.this.getTarget();
            return livingentity != null ? AngelEntity.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
        }

        public void start() {
            this.nextSweepTick = this.adjustedTickDelay(10);
            AngelEntity.this.attackPhase = AngelEntity.AttackPhase.CIRCLE;
            this.setAnchorAboveTarget();
        }

        public void stop() {
            AngelEntity.this.anchorPoint = AngelEntity.this.level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, AngelEntity.this.anchorPoint).above(10 + AngelEntity.this.random.nextInt(20));
        }

        public void tick() {
            if (AngelEntity.this.attackPhase == AngelEntity.AttackPhase.CIRCLE) {
                --this.nextSweepTick;
                if (this.nextSweepTick <= 0) {
                    AngelEntity.this.attackPhase = AngelEntity.AttackPhase.SWOOP;
                    this.setAnchorAboveTarget();
                    this.nextSweepTick = this.adjustedTickDelay((8 + AngelEntity.this.random.nextInt(4)) * 20);
                    AngelEntity.this.playSound(SoundEvents.TRIDENT_THROW, 10.0F, 0.95F + AngelEntity.this.random.nextFloat() * 0.1F);
                }
            }

        }

        private void setAnchorAboveTarget() {
            AngelEntity.this.anchorPoint = AngelEntity.this.getTarget().blockPosition().above(20 + AngelEntity.this.random.nextInt(20));
            if (AngelEntity.this.anchorPoint.getY() < AngelEntity.this.level.getSeaLevel()) {
                AngelEntity.this.anchorPoint = new BlockPos(AngelEntity.this.anchorPoint.getX(), AngelEntity.this.level.getSeaLevel() + 1, AngelEntity.this.anchorPoint.getZ());
            }

        }
    }

    class AngelBodyRotationControl extends BodyRotationControl {
        public AngelBodyRotationControl(Mob p_33216_) {
            super(p_33216_);
        }

        public void clientTick() {
            AngelEntity.this.yHeadRot = AngelEntity.this.yBodyRot;
            AngelEntity.this.yBodyRot = AngelEntity.this.getYRot();
        }
    }

    class AngelCircleAroundAnchorGoal extends AngelEntity.AngelMoveTargetGoal {
        private float angle;
        private float distance;
        private float height;
        private float clockwise;

        public boolean canUse() {
            return AngelEntity.this.getTarget() == null || AngelEntity.this.attackPhase == AngelEntity.AttackPhase.CIRCLE;
        }

        public void start() {
            this.distance = 5.0F + AngelEntity.this.random.nextFloat() * 10.0F;
            this.height = -4.0F + AngelEntity.this.random.nextFloat() * 9.0F;
            this.clockwise = AngelEntity.this.random.nextBoolean() ? 1.0F : -1.0F;
            this.selectNext();
        }

        public void tick() {
            if (AngelEntity.this.random.nextInt(this.adjustedTickDelay(350)) == 0) {
                this.height = -4.0F + AngelEntity.this.random.nextFloat() * 9.0F;
            }

            if (AngelEntity.this.random.nextInt(this.adjustedTickDelay(250)) == 0) {
                ++this.distance;
                if (this.distance > 15.0F) {
                    this.distance = 5.0F;
                    this.clockwise = -this.clockwise;
                }
            }

            if (AngelEntity.this.random.nextInt(this.adjustedTickDelay(450)) == 0) {
                this.angle = AngelEntity.this.random.nextFloat() * 2.0F * (float)Math.PI;
                this.selectNext();
            }

            if (this.touchingTarget()) {
                this.selectNext();
            }

            if (AngelEntity.this.moveTargetPoint.y < AngelEntity.this.getY() && !AngelEntity.this.level.isEmptyBlock(AngelEntity.this.blockPosition().below(1))) {
                this.height = Math.max(1.0F, this.height);
                this.selectNext();
            }

            if (AngelEntity.this.moveTargetPoint.y > AngelEntity.this.getY() && !AngelEntity.this.level.isEmptyBlock(AngelEntity.this.blockPosition().above(1))) {
                this.height = Math.min(-1.0F, this.height);
                this.selectNext();
            }

        }

        private void selectNext() {
            if (BlockPos.ZERO.equals(AngelEntity.this.anchorPoint)) {
                AngelEntity.this.anchorPoint = AngelEntity.this.blockPosition();
            }

            this.angle += this.clockwise * 15.0F * ((float)Math.PI / 180F);
            AngelEntity.this.moveTargetPoint = Vec3.atLowerCornerOf(AngelEntity.this.anchorPoint).add((double)(this.distance * Mth.cos(this.angle)), (double)(-4.0F + this.height), (double)(this.distance * Mth.sin(this.angle)));
        }
    }

    class AngelLookControl extends LookControl {
        public AngelLookControl(Mob p_33235_) {
            super(p_33235_);
        }

        public void tick() {
        }
    }

    class AngelMoveControl extends MoveControl {
        private float speed = 1.0F;

        public AngelMoveControl(Mob p_33241_) {
            super(p_33241_);
        }

        public void tick() {
            if (AngelEntity.this.horizontalCollision) {
                AngelEntity.this.setYRot(AngelEntity.this.getYRot() + 180.0F);
                this.speed = 1.5F;
            }

            double d0 = AngelEntity.this.moveTargetPoint.x - AngelEntity.this.getX();
            double d1 = AngelEntity.this.moveTargetPoint.y - AngelEntity.this.getY();
            double d2 = AngelEntity.this.moveTargetPoint.z - AngelEntity.this.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            if (Math.abs(d3) > (double)1.0E-5F) {
                double d4 = 1.0D - Math.abs(d1 * (double)0.7F) / d3;
                d0 *= d4;
                d2 *= d4;
                d3 = Math.sqrt(d0 * d0 + d2 * d2);
                double d5 = Math.sqrt(d0 * d0 + d2 * d2 + d1 * d1);
                float f = AngelEntity.this.getYRot();
                float f1 = (float)Mth.atan2(d2, d0);
                float f2 = Mth.wrapDegrees(AngelEntity.this.getYRot() + 90.0F);
                float f3 = Mth.wrapDegrees(f1 * (180F / (float)Math.PI));
                AngelEntity.this.setYRot(Mth.approachDegrees(f2, f3, 4.0F) - 90.0F);
                AngelEntity.this.yBodyRot = AngelEntity.this.getYRot();
                if (Mth.degreesDifferenceAbs(f, AngelEntity.this.getYRot()) < 3.0F) {
                    this.speed = Mth.approach(this.speed, 1.0F, 0.005F * (3.5F / this.speed));
                } else {
                    this.speed = Mth.approach(this.speed, 1.3F, 0.025F);
                }

                float f4 = (float)(-(Mth.atan2(-d1, d3) * (double)(180F / (float)Math.PI)));
                AngelEntity.this.setXRot(f4);
                float f5 = AngelEntity.this.getYRot() + 90.0F;
                double d6 = (double)(this.speed * Mth.cos(f5 * ((float)Math.PI / 180F))) * Math.abs(d0 / d5);
                double d7 = (double)(this.speed * Mth.sin(f5 * ((float)Math.PI / 180F))) * Math.abs(d2 / d5);
                double d8 = (double)(this.speed * Mth.sin(f4 * ((float)Math.PI / 180F))) * Math.abs(d1 / d5);
                Vec3 vec3 = AngelEntity.this.getDeltaMovement();
                AngelEntity.this.setDeltaMovement(vec3.add((new Vec3(d6, d8, d7)).subtract(vec3).scale(0.2D)));
            }

        }
    }

    abstract class AngelMoveTargetGoal extends Goal {
        public AngelMoveTargetGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        protected boolean touchingTarget() {
            return AngelEntity.this.moveTargetPoint.distanceToSqr(AngelEntity.this.getX(), AngelEntity.this.getY(), AngelEntity.this.getZ()) < 4.0D;
        }
    }

    class AngelSweepAttackGoal extends AngelEntity.AngelMoveTargetGoal {
        private static final int CAT_SEARCH_TICK_DELAY = 20;
        private boolean isScaredOfCat;
        private int catSearchTick;

        public boolean canUse() {
            return AngelEntity.this.getTarget() != null && AngelEntity.this.attackPhase == AngelEntity.AttackPhase.SWOOP;
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = AngelEntity.this.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else {
                if (livingentity instanceof Player) {
                    Player player = (Player)livingentity;
                    if (livingentity.isSpectator() || player.isCreative()) {
                        return false;
                    }
                }

                if (!this.canUse()) {
                    return false;
                } else {
                    if (AngelEntity.this.tickCount > this.catSearchTick) {
                        this.catSearchTick = AngelEntity.this.tickCount + 20;
                        List<Cat> list = AngelEntity.this.level.getEntitiesOfClass(Cat.class, AngelEntity.this.getBoundingBox().inflate(16.0D), EntitySelector.ENTITY_STILL_ALIVE);

                        for(Cat cat : list) {
                            cat.hiss();
                        }

                        this.isScaredOfCat = !list.isEmpty();
                    }

                    return !this.isScaredOfCat;
                }
            }
        }

        public void start() {
        }

        public void stop() {
            AngelEntity.this.setTarget((LivingEntity)null);
            AngelEntity.this.attackPhase = AngelEntity.AttackPhase.CIRCLE;
        }

        public void tick() {
            LivingEntity livingentity = AngelEntity.this.getTarget();
            if (livingentity != null) {
                AngelEntity.this.moveTargetPoint = new Vec3(livingentity.getX(), livingentity.getY(0.5D), livingentity.getZ());
                if (AngelEntity.this.getBoundingBox().inflate((double)0.2F).intersects(livingentity.getBoundingBox())) {
                    AngelEntity.this.doHurtTarget(livingentity);
                    AngelEntity.this.attackPhase = AngelEntity.AttackPhase.CIRCLE;
                    if (!AngelEntity.this.isSilent()) {
                        AngelEntity.this.level.levelEvent(1039, AngelEntity.this.blockPosition(), 0);
                    }
                } else if (AngelEntity.this.horizontalCollision || AngelEntity.this.hurtTime > 0) {
                    AngelEntity.this.attackPhase = AngelEntity.AttackPhase.CIRCLE;
                }

            }
        }
    }

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }

}
