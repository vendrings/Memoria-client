package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.PathEntity;
import net.minecraft.src.Profiler;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public abstract class EntityCreature extends EntityLiving {

   private PathEntity field_749_a;
   protected Entity field_751_f;
   protected boolean field_750_g = false;
   protected int field_35174_at = 0;


   public EntityCreature(World p_i730_1_) {
      super(p_i730_1_);
   }

   protected boolean func_25028_d_() {
      return false;
   }

   protected void func_418_b_() {
      Profiler.func_40663_a("ai");
      if(this.field_35174_at > 0) {
         --this.field_35174_at;
      }

      this.field_750_g = this.func_25028_d_();
      float var1 = 16.0F;
      if(this.field_751_f == null) {
         this.field_751_f = this.func_438_i();
         if(this.field_751_f != null) {
            this.field_749_a = this.field_615_ag.func_48463_a(this, this.field_751_f, var1, true, false, false, true);
         }
      } else if(!this.field_751_f.func_354_B()) {
         this.field_751_f = null;
      } else {
         float var2 = this.field_751_f.func_379_d(this);
         if(this.func_420_c(this.field_751_f)) {
            this.func_437_a(this.field_751_f, var2);
         } else {
            this.func_28022_b(this.field_751_f, var2);
         }
      }

      Profiler.func_40662_b();
      if(!this.field_750_g && this.field_751_f != null && (this.field_749_a == null || this.field_9312_bd.nextInt(20) == 0)) {
         this.field_749_a = this.field_615_ag.func_48463_a(this, this.field_751_f, var1, true, false, false, true);
      } else if(!this.field_750_g && (this.field_749_a == null && this.field_9312_bd.nextInt(180) == 0 || this.field_9312_bd.nextInt(120) == 0 || this.field_35174_at > 0) && this.field_9344_ag < 100) {
         this.func_31026_E();
      }

      int var21 = MathHelper.func_1108_b(this.field_601_au.field_1697_b + 0.5D);
      boolean var3 = this.func_27013_ag();
      boolean var4 = this.func_359_G();
      this.field_604_ar = 0.0F;
      if(this.field_749_a != null && this.field_9312_bd.nextInt(100) != 0) {
         Profiler.func_40663_a("followpath");
         Vec3D var5 = this.field_749_a.func_48640_a(this);
         double var6 = (double)(this.field_644_aC * 2.0F);

         while(var5 != null && var5.func_1255_d(this.field_611_ak, var5.field_1775_b, this.field_609_am) < var6 * var6) {
            this.field_749_a.func_1206_a();
            if(this.field_749_a.func_1207_b()) {
               var5 = null;
               this.field_749_a = null;
            } else {
               var5 = this.field_749_a.func_48640_a(this);
            }
         }

         this.field_9336_ak = false;
         if(var5 != null) {
            double var8 = var5.field_1776_a - this.field_611_ak;
            double var10 = var5.field_1779_c - this.field_609_am;
            double var12 = var5.field_1775_b - (double)var21;
            float var14 = (float)(Math.atan2(var10, var8) * 180.0D / 3.1415927410125732D) - 90.0F;
            float var15 = var14 - this.field_605_aq;

            for(this.field_9340_ai = this.field_9333_am; var15 < -180.0F; var15 += 360.0F) {
               ;
            }

            while(var15 >= 180.0F) {
               var15 -= 360.0F;
            }

            if(var15 > 30.0F) {
               var15 = 30.0F;
            }

            if(var15 < -30.0F) {
               var15 = -30.0F;
            }

            this.field_605_aq += var15;
            if(this.field_750_g && this.field_751_f != null) {
               double var16 = this.field_751_f.field_611_ak - this.field_611_ak;
               double var18 = this.field_751_f.field_609_am - this.field_609_am;
               float var20 = this.field_605_aq;
               this.field_605_aq = (float)(Math.atan2(var18, var16) * 180.0D / 3.1415927410125732D) - 90.0F;
               var15 = (var20 - this.field_605_aq + 90.0F) * 3.1415927F / 180.0F;
               this.field_9342_ah = -MathHelper.func_1106_a(var15) * this.field_9340_ai * 1.0F;
               this.field_9340_ai = MathHelper.func_1114_b(var15) * this.field_9340_ai * 1.0F;
            }

            if(var12 > 0.0D) {
               this.field_9336_ak = true;
            }
         }

         if(this.field_751_f != null) {
            this.func_426_b(this.field_751_f, 30.0F, 30.0F);
         }

         if(this.field_9297_aI && !this.func_25031_E()) {
            this.field_9336_ak = true;
         }

         if(this.field_9312_bd.nextFloat() < 0.8F && (var3 || var4)) {
            this.field_9336_ak = true;
         }

         Profiler.func_40662_b();
      } else {
         super.func_418_b_();
         this.field_749_a = null;
      }
   }

   protected void func_31026_E() {
      Profiler.func_40663_a("stroll");
      boolean var1 = false;
      int var2 = -1;
      int var3 = -1;
      int var4 = -1;
      float var5 = -99999.0F;

      for(int var6 = 0; var6 < 10; ++var6) {
         int var7 = MathHelper.func_1108_b(this.field_611_ak + (double)this.field_9312_bd.nextInt(13) - 6.0D);
         int var8 = MathHelper.func_1108_b(this.field_610_al + (double)this.field_9312_bd.nextInt(7) - 3.0D);
         int var9 = MathHelper.func_1108_b(this.field_609_am + (double)this.field_9312_bd.nextInt(13) - 6.0D);
         float var10 = this.func_439_a(var7, var8, var9);
         if(var10 > var5) {
            var5 = var10;
            var2 = var7;
            var3 = var8;
            var4 = var9;
            var1 = true;
         }
      }

      if(var1) {
         this.field_749_a = this.field_615_ag.func_48460_a(this, var2, var3, var4, 10.0F, true, false, false, true);
      }

      Profiler.func_40662_b();
   }

   protected void func_437_a(Entity p_437_1_, float p_437_2_) {}

   protected void func_28022_b(Entity p_28022_1_, float p_28022_2_) {}

   public float func_439_a(int p_439_1_, int p_439_2_, int p_439_3_) {
      return 0.0F;
   }

   protected Entity func_438_i() {
      return null;
   }

   public boolean func_433_a() {
      int var1 = MathHelper.func_1108_b(this.field_611_ak);
      int var2 = MathHelper.func_1108_b(this.field_601_au.field_1697_b);
      int var3 = MathHelper.func_1108_b(this.field_609_am);
      return super.func_433_a() && this.func_439_a(var1, var2, var3) >= 0.0F;
   }

   public boolean func_25031_E() {
      return this.field_749_a != null;
   }

   public void func_25029_a(PathEntity p_25029_1_) {
      this.field_749_a = p_25029_1_;
   }

   public Entity func_25030_F() {
      return this.field_751_f;
   }

   public void func_25032_c(Entity p_25032_1_) {
      this.field_751_f = p_25032_1_;
   }

   protected float func_35166_t_() {
      if(this.func_46006_aR()) {
         return 1.0F;
      } else {
         float var1 = super.func_35166_t_();
         if(this.field_35174_at > 0) {
            var1 *= 2.0F;
         }

         return var1;
      }
   }
}
