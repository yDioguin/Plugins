package pt.dioguin.fabricar.utils;

import java.util.List;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public interface ItemSpecification<T extends ItemBuilder> {
  T setDisplayName(String paramString);
  
  T setLore(List<String> paramList);
  
  T setLore(String... paramVarArgs);
  
  T unbreakable();
  
  T addEnchantment(Enchantment paramEnchantment, int paramInt);
  
  T hideFlag(ItemFlag paramItemFlag);
  
  T hideAllFlags();
  
  ItemStack build();
}


/* Location:              C:\Users\Diogo Lima\Desktop\Coisas\Plugins\Meus Plugins\D_Encantar.jar!\me\items\ItemSpecification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */