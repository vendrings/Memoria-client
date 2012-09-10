package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityTNTPrimed extends Entity {

   public int field_689_a;


   public EntityTNTPrimed(World p_i104_1_) {
      super(p_i104_1_);
      this.field_689_a = 0;
      this.field_618_ad = true;
      this.func_371_a(0.98F, 0.98F);
      this.field_9292_aO = this.field_643_aD / 2.0F;
   }

   public EntityTNTPrimed(World p_i105_1_, double p_i105_2_, double p_i105_4_, double p_i105_6_) {
      this(p_i105_1_);
      this.func_347_a(p_i105_2_, p_i105_4_, p_i105_6_);
      float var8 = (float)(Math.random() * 3.1415927410125732D * 2.0D);
      this.field_608_an = (double)(-((float)Math.sin((double)var8)) * 0.02F);
      this.field_607_ao = 0.20000000298023224D;
      this.field_606_ap = (double)(-((float)Math.cos((double)var8)) * 0.02F);
      this.field_689_a = 80;
      this.field_9285_at = p_i105_2_;
      this.field_9284_au = p_i105_4_;
      this.field_9283_av = p_i105_6_;
   }

   protected void func_21057_b() {}

   protected boolean func_25021_m() {
      return false;
   }

   public boolean func_401_c_() {
      return !this.field_646_aA;
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      this.field_607_ao -= 0.03999999910593033D;
      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      this.field_608_an *= 0.9800000190734863D;
      this.field_607_ao *= 0.9800000190734863D;
      this.field_606_ap *= 0.9800000190734863D;
      if(this.field_9298_aH) {
         this.field_608_an *= 0.699999988079071D;
         this.field_606_ap *= 0.699999988079071D;
         this.field_607_ao *= -0.5D;
      }

      if(this.field_689_a-- <= 0) {
         if(!this.field_615_ag.field_1026_y) {
            this.func_395_F();
            this.func_409_i();
         } else {
            this.func_395_F();
         }
      } else {
         this.field_615_ag.func_694_a("smoke", this.field_611_ak, this.field_610_al + 0.5D, this.field_609_am, 0.0D, 0.0D, 0.0D);
      }

   }

   private void func_409_i() {
      float var1 = 4.0F;
      this.field_615_ag.func_12243_a((Entity)null, this.field_611_ak, this.field_610_al, this.field_609_am, var1);
   }

   protected void func_352_a(NBTTagCompound p_352_1_) {
      p_352_1_.func_761_a("Fuse", (byte)this.field_689_a);
   }

   protected void func_357_b(NBTTagCompound p_357_1_) {
      this.field_689_a = p_357_1_.func_746_c("Fuse");
   }

   public float func_392_h_() {
      return 0.0F;
   }
}
