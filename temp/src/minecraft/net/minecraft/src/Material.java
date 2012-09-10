package net.minecraft.src;

import net.minecraft.src.MapColor;
import net.minecraft.src.MaterialLiquid;
import net.minecraft.src.MaterialLogic;
import net.minecraft.src.MaterialPortal;
import net.minecraft.src.MaterialTransparent;
import net.minecraft.src.MaterialWeb;

public class Material {

   public static final Material field_1337_a = new MaterialTransparent(MapColor.field_28212_b);
   public static final Material field_28130_b = new Material(MapColor.field_28211_c);
   public static final Material field_1336_b = new Material(MapColor.field_28202_l);
   public static final Material field_1335_c = (new Material(MapColor.field_28199_o)).func_4130_f();
   public static final Material field_1334_d = (new Material(MapColor.field_28201_m)).func_31062_n();
   public static final Material field_1333_e = (new Material(MapColor.field_28206_h)).func_31062_n();
   public static final Material field_1332_f = (new MaterialLiquid(MapColor.field_28200_n)).func_31063_k();
   public static final Material field_1331_g = (new MaterialLiquid(MapColor.field_28208_f)).func_31063_k();
   public static final Material field_4265_h = (new Material(MapColor.field_28205_i)).func_4130_f().func_28127_i().func_31063_k();
   public static final Material field_1329_i = (new MaterialLogic(MapColor.field_28205_i)).func_31063_k();
   public static final Material field_35495_k = (new MaterialLogic(MapColor.field_28205_i)).func_4130_f().func_31063_k().func_27284_f();
   public static final Material field_1328_j = new Material(MapColor.field_28209_e);
   public static final Material field_4264_k = (new Material(MapColor.field_28209_e)).func_4130_f();
   public static final Material field_1326_l = (new MaterialTransparent(MapColor.field_28212_b)).func_31063_k();
   public static final Material field_1325_m = new Material(MapColor.field_28210_d);
   public static final Material field_1324_n = (new MaterialLogic(MapColor.field_28212_b)).func_31063_k();
   public static final Material field_4263_o = (new Material(MapColor.field_28212_b)).func_28127_i();
   public static final Material field_48468_r = new Material(MapColor.field_28212_b);
   public static final Material field_1322_p = (new Material(MapColor.field_28208_f)).func_4130_f().func_28127_i();
   public static final Material field_4262_q = (new Material(MapColor.field_28205_i)).func_31063_k();
   public static final Material field_1320_r = (new Material(MapColor.field_28207_g)).func_28127_i();
   public static final Material field_1319_s = (new MaterialLogic(MapColor.field_28204_j)).func_27284_f().func_28127_i().func_31062_n().func_31063_k();
   public static final Material field_1318_t = (new Material(MapColor.field_28204_j)).func_31062_n();
   public static final Material field_1317_u = (new Material(MapColor.field_28205_i)).func_28127_i().func_31063_k();
   public static final Material field_1316_v = new Material(MapColor.field_28203_k);
   public static final Material field_4261_w = (new Material(MapColor.field_28205_i)).func_31063_k();
   public static final Material field_41056_z = (new Material(MapColor.field_28205_i)).func_31063_k();
   public static final Material field_4260_x = (new MaterialPortal(MapColor.field_28212_b)).func_31060_l();
   public static final Material field_21150_y = (new Material(MapColor.field_28212_b)).func_31063_k();
   public static final Material field_31068_A = (new MaterialWeb(MapColor.field_28209_e)).func_31062_n().func_31063_k();
   public static final Material field_31067_B = (new Material(MapColor.field_28201_m)).func_31060_l();
   private boolean field_4259_y;
   private boolean field_27285_A;
   private boolean field_28128_D;
   public final MapColor field_28129_A;
   private boolean field_31066_G = true;
   private int field_31065_H;


   public Material(MapColor p_i16_1_) {
      this.field_28129_A = p_i16_1_;
   }

   public boolean func_879_d() {
      return false;
   }

   public boolean func_878_a() {
      return true;
   }

   public boolean func_881_b() {
      return true;
   }

   public boolean func_880_c() {
      return true;
   }

   private Material func_28127_i() {
      this.field_28128_D = true;
      return this;
   }

   protected Material func_31062_n() {
      this.field_31066_G = false;
      return this;
   }

   protected Material func_4130_f() {
      this.field_4259_y = true;
      return this;
   }

   public boolean func_876_e() {
      return this.field_4259_y;
   }

   public Material func_27284_f() {
      this.field_27285_A = true;
      return this;
   }

   public boolean func_27283_g() {
      return this.field_27285_A;
   }

   public boolean func_28126_h() {
      return this.field_28128_D?false:this.func_880_c();
   }

   public boolean func_31061_i() {
      return this.field_31066_G;
   }

   public int func_31064_j() {
      return this.field_31065_H;
   }

   protected Material func_31063_k() {
      this.field_31065_H = 1;
      return this;
   }

   protected Material func_31060_l() {
      this.field_31065_H = 2;
      return this;
   }

}
