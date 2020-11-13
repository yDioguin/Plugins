/*    */ package pt.dioguin.fabricar.utils;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.stream.Collectors;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.inventory.ItemFlag;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ public class ItemBuilder
/*    */   implements ItemSpecification<ItemBuilder>
/*    */ {
/*    */   protected ItemMeta itemMeta;
/*    */   protected ItemStack itemStack;
/*    */   protected Material material;
/*    */   protected int quantity;
/*    */   protected int data;
/*    */   
/*    */   public ItemBuilder(Material material) {
/* 23 */     this.material = material;
/* 24 */     this.itemStack = new ItemStack(material, 1);
/* 25 */     this.itemMeta = this.itemStack.getItemMeta();
/*    */   }
/*    */   
/*    */   public ItemBuilder(Material material, int quantity) {
/* 29 */     this.material = material;
/* 30 */     this.quantity = quantity;
/* 31 */     this.itemStack = new ItemStack(material, quantity);
/* 32 */     this.itemMeta = this.itemStack.getItemMeta();
/*    */   }
/*    */   
/*    */   public ItemBuilder(Material material, int quantity, int data) {
/* 36 */     this.material = material;
/* 37 */     this.quantity = quantity;
/* 38 */     this.data = data;
/* 39 */     this.itemStack = new ItemStack(material, quantity, (short)data);
/* 40 */     this.itemMeta = this.itemStack.getItemMeta();
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemBuilder setDisplayName(String name) {
/* 45 */     this.itemMeta.setDisplayName(name.replace("&", "§"));
/* 46 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemBuilder setLore(List<String> lore) {
/* 51 */     this.itemMeta.setLore((List)lore.stream().map(x -> x.replace("&", "§")).collect(Collectors.toList()));
/* 52 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemBuilder setLore(String... lore) {
/* 57 */     List<String> list = Arrays.asList(lore);
/* 58 */     this.itemMeta.setLore((List)list.stream().map(x -> x.replace("&", "§")).collect(Collectors.toList()));
/* 59 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemBuilder unbreakable() {
/* 64 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemBuilder addEnchantment(Enchantment enchantment, int strength) {
/* 70 */     this.itemMeta.addEnchant(enchantment, strength, true);
/* 71 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemBuilder hideAllFlags() {
/* 77 */     this.itemMeta.addItemFlags(ItemFlag.values());
/* 78 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemBuilder hideFlag(ItemFlag itemFlag) {
/* 84 */     this.itemMeta.addItemFlags(new ItemFlag[] { itemFlag });
/* 85 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack build() {
/* 90 */     this.itemStack.setItemMeta(this.itemMeta);
/* 91 */     return this.itemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Diogo Lima\Desktop\Coisas\Plugins\Meus Plugins\D_Encantar.jar!\me\items\ItemBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */