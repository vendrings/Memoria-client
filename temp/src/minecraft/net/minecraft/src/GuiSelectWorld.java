package net.minecraft.src;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiCreateWorld;
import net.minecraft.src.GuiRenameWorld;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiWorldSlot;
import net.minecraft.src.GuiYesNo;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.MathHelper;
import net.minecraft.src.PlayerControllerCreative;
import net.minecraft.src.PlayerControllerSP;
import net.minecraft.src.SaveFormatComparator;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.WorldSettings;

public class GuiSelectWorld extends GuiScreen {

   private final DateFormat field_22102_i = new SimpleDateFormat();
   protected GuiScreen field_958_a;
   protected String field_960_h = "Select world";
   private boolean field_959_i = false;
   private int field_22101_l;
   private List field_22100_m;
   private GuiWorldSlot field_22099_n;
   private String field_22098_o;
   private String field_22097_p;
   private String[] field_35316_k = new String[2];
   private boolean field_22096_q;
   private GuiButton field_22095_r;
   private GuiButton field_22104_s;
   private GuiButton field_22103_t;


   public GuiSelectWorld(GuiScreen p_i469_1_) {
      this.field_958_a = p_i469_1_;
   }

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_960_h = var1.func_20163_a("selectWorld.title");
      this.field_22098_o = var1.func_20163_a("selectWorld.world");
      this.field_22097_p = var1.func_20163_a("selectWorld.conversion");
      this.field_35316_k[0] = var1.func_20163_a("gameMode.survival");
      this.field_35316_k[1] = var1.func_20163_a("gameMode.creative");
      this.func_22084_k();
      this.field_22099_n = new GuiWorldSlot(this);
      this.field_22099_n.func_22240_a(this.field_949_e, 4, 5);
      this.func_585_j();
   }

   private void func_22084_k() {
      ISaveFormat var1 = this.field_945_b.func_22004_c();
      this.field_22100_m = var1.func_22176_b();
      Collections.sort(this.field_22100_m);
      this.field_22101_l = -1;
   }

   protected String func_22091_c(int p_22091_1_) {
      return ((SaveFormatComparator)this.field_22100_m.get(p_22091_1_)).func_22164_a();
   }

   protected String func_22094_d(int p_22094_1_) {
      String var2 = ((SaveFormatComparator)this.field_22100_m.get(p_22094_1_)).func_22162_b();
      if(var2 == null || MathHelper.func_22282_a(var2)) {
         StringTranslate var3 = StringTranslate.func_20162_a();
         var2 = var3.func_20163_a("selectWorld.world") + " " + (p_22094_1_ + 1);
      }

      return var2;
   }

   public void func_585_j() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_949_e.add(this.field_22104_s = new GuiButton(1, this.field_951_c / 2 - 154, this.field_950_d - 52, 150, 20, var1.func_20163_a("selectWorld.select")));
      this.field_949_e.add(this.field_22103_t = new GuiButton(6, this.field_951_c / 2 - 154, this.field_950_d - 28, 70, 20, var1.func_20163_a("selectWorld.rename")));
      this.field_949_e.add(this.field_22095_r = new GuiButton(2, this.field_951_c / 2 - 74, this.field_950_d - 28, 70, 20, var1.func_20163_a("selectWorld.delete")));
      this.field_949_e.add(new GuiButton(3, this.field_951_c / 2 + 4, this.field_950_d - 52, 150, 20, var1.func_20163_a("selectWorld.create")));
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 + 4, this.field_950_d - 28, 150, 20, var1.func_20163_a("gui.cancel")));
      this.field_22104_s.field_937_g = false;
      this.field_22095_r.field_937_g = false;
      this.field_22103_t.field_937_g = false;
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         if(p_572_1_.field_938_f == 2) {
            String var2 = this.func_22094_d(this.field_22101_l);
            if(var2 != null) {
               this.field_22096_q = true;
               StringTranslate var3 = StringTranslate.func_20162_a();
               String var4 = var3.func_20163_a("selectWorld.deleteQuestion");
               String var5 = "\'" + var2 + "\' " + var3.func_20163_a("selectWorld.deleteWarning");
               String var6 = var3.func_20163_a("selectWorld.deleteButton");
               String var7 = var3.func_20163_a("gui.cancel");
               GuiYesNo var8 = new GuiYesNo(this, var4, var5, var6, var7, this.field_22101_l);
               this.field_945_b.func_6272_a(var8);
            }
         } else if(p_572_1_.field_938_f == 1) {
            this.func_584_c(this.field_22101_l);
         } else if(p_572_1_.field_938_f == 3) {
            this.field_945_b.func_6272_a(new GuiCreateWorld(this));
         } else if(p_572_1_.field_938_f == 6) {
            this.field_945_b.func_6272_a(new GuiRenameWorld(this, this.func_22091_c(this.field_22101_l)));
         } else if(p_572_1_.field_938_f == 0) {
            this.field_945_b.func_6272_a(this.field_958_a);
         } else {
            this.field_22099_n.func_22241_a(p_572_1_);
         }

      }
   }

   public void func_584_c(int p_584_1_) {
      this.field_945_b.func_6272_a((GuiScreen)null);
      if(!this.field_959_i) {
         this.field_959_i = true;
         int var2 = ((SaveFormatComparator)this.field_22100_m.get(p_584_1_)).func_35719_f();
         if(var2 == 0) {
            this.field_945_b.field_6327_b = new PlayerControllerSP(this.field_945_b);
         } else {
            this.field_945_b.field_6327_b = new PlayerControllerCreative(this.field_945_b);
         }

         String var3 = this.func_22091_c(p_584_1_);
         if(var3 == null) {
            var3 = "World" + p_584_1_;
         }

         this.field_945_b.func_6247_b(var3, this.func_22094_d(p_584_1_), (WorldSettings)null);
         this.field_945_b.func_6272_a((GuiScreen)null);
      }
   }

   public void func_568_a(boolean p_568_1_, int p_568_2_) {
      if(this.field_22096_q) {
         this.field_22096_q = false;
         if(p_568_1_) {
            ISaveFormat var3 = this.field_945_b.func_22004_c();
            var3.func_22177_c();
            var3.func_22172_c(this.func_22091_c(p_568_2_));
            this.func_22084_k();
         }

         this.field_945_b.func_6272_a(this);
      }

   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.field_22099_n.func_22243_a(p_571_1_, p_571_2_, p_571_3_);
      this.func_548_a(this.field_6451_g, this.field_960_h, this.field_951_c / 2, 20, 16777215);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }

   // $FF: synthetic method
   static List func_22090_a(GuiSelectWorld p_22090_0_) {
      return p_22090_0_.field_22100_m;
   }

   // $FF: synthetic method
   static int func_22089_a(GuiSelectWorld p_22089_0_, int p_22089_1_) {
      return p_22089_0_.field_22101_l = p_22089_1_;
   }

   // $FF: synthetic method
   static int func_22086_b(GuiSelectWorld p_22086_0_) {
      return p_22086_0_.field_22101_l;
   }

   // $FF: synthetic method
   static GuiButton func_22083_c(GuiSelectWorld p_22083_0_) {
      return p_22083_0_.field_22104_s;
   }

   // $FF: synthetic method
   static GuiButton func_22085_d(GuiSelectWorld p_22085_0_) {
      return p_22085_0_.field_22095_r;
   }

   // $FF: synthetic method
   static GuiButton func_22092_e(GuiSelectWorld p_22092_0_) {
      return p_22092_0_.field_22103_t;
   }

   // $FF: synthetic method
   static String func_22087_f(GuiSelectWorld p_22087_0_) {
      return p_22087_0_.field_22098_o;
   }

   // $FF: synthetic method
   static DateFormat func_22093_g(GuiSelectWorld p_22093_0_) {
      return p_22093_0_.field_22102_i;
   }

   // $FF: synthetic method
   static String func_22088_h(GuiSelectWorld p_22088_0_) {
      return p_22088_0_.field_22097_p;
   }

   // $FF: synthetic method
   static String[] func_35315_i(GuiSelectWorld p_35315_0_) {
      return p_35315_0_.field_35316_k;
   }
}
