package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockSand;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityFallingSand extends Entity {

   public int field_799_a;
   public int field_798_b = 0;


   public EntityFallingSand(World p_i763_1_) {
      super(p_i763_1_);
   }

   public EntityFallingSand(World p_i764_1_, double p_i764_2_, double p_i764_4_, double p_i764_6_, int p_i764_8_) {
      super(p_i764_1_);
      this.field_799_a = p_i764_8_;
      this.field_618_ad = true;
      this.func_371_a(0.98F, 0.98F);
      this.field_9292_aO = this.field_643_aD / 2.0F;
      this.func_347_a(p_i764_2_, p_i764_4_, p_i764_6_);
      this.field_608_an = 0.0D;
      this.field_607_ao = 0.0D;
      this.field_606_ap = 0.0D;
      this.field_9285_at = p_i764_2_;
      this.field_9284_au = p_i764_4_;
      this.field_9283_av = p_i764_6_;
   }

   protected boolean func_25021_m() {
      return false;
   }

   protected void func_21057_b() {}

   public boolean func_401_c_() {
      return !this.field_646_aA;
   }

   public void func_370_e_() {
      if(this.field_799_a == 0) {
         this.func_395_F();
      } else {
         this.field_9285_at = this.field_611_ak;
         this.field_9284_au = this.field_610_al;
         this.field_9283_av = this.field_609_am;
         ++this.field_798_b;
         this.field_607_ao -= 0.03999999910593033D;
         this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
         this.field_608_an *= 0.9800000190734863D;
         this.field_607_ao *= 0.9800000190734863D;
         this.field_606_ap *= 0.9800000190734863D;
         int var1 = MathHelper.func_1108_b(this.field_611_ak);
         int var2 = MathHelper.func_1108_b(this.field_610_al);
         int var3 = MathHelper.func_1108_b(this.field_609_am);
         if(this.field_798_b == 1 && this.field_615_ag.func_600_a(var1, var2, var3) == this.field_799_a) {
            this.field_615_ag.func_690_d(var1, var2, var3, 0);
         } else if(!this.field_615_ag.field_1026_y && this.field_798_b == 1) {
            this.func_395_F();
         }

         if(this.field_9298_aH) {
            this.field_608_an *= 0.699999988079071D;
            this.field_606_ap *= 0.699999988079071D;
            this.field_607_ao *= -0.5D;
            if(this.field_615_ag.func_600_a(var1, var2, var3) != Block.field_9268_ac.field_376_bc) {
               this.func_395_F();
               if((!this.field_615_ag.func_695_a(this.field_799_a, var1, var2, var3, true, 1) || BlockSand.func_316_a_(this.field_615_ag, var1, var2 - 1, var3) || !this.field_615_ag.func_690_d(var1, var2, var3, this.field_799_a)) && !this.field_615_ag.field_1026_y) {
                  this.func_367_b(this.field_799_a, 1);
               }
            }
         } else if(this.field_798_b > 100 && !this.field_615_ag.field_1026_y && (var2 < 1 || var2 > 256) || this.field_798_b > 600) {
            this.func_367_b(this.field_799_a, 1);
            this.func_395_F();
         }

      }
   }

   protected void func_352_a(NBTTagCompound p_352_1_) {
      p_352_1_.func_761_a("Tile", (byte)this.field_799_a);
   }

   protected void func_357_b(NBTTagCompound p_357_1_) {
      this.field_799_a = p_357_1_.func_746_c("Tile") & 255;
   }

   public float func_392_h_() {
      return 0.0F;
   }

   public World func_465_i() {
      return this.field_615_ag;
   }
}
