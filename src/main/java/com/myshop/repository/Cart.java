//package com.myshop.repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.myshop.entity.CartItem;
//import com.myshop.entity.Product;
//
//public class Cart {
//	private List<CartItem> items;
//	private double total;
//	
//	public Cart() {
//		items = new ArrayList<CartItem>();
//		total = 0;
//	}
//	
//	public CartItem getItems(Product product) {
//		for(CartItem item: items) {
//			if(item.getProduct().getProductId() == product.getProductId())
//				return item;
//		}
//		return null;
//	}
//	
//	public List<CartItem> getItems(){
//		return items;
//	}
//	
//	public int getItemCount() {
//		return items.size();
//	}
//	
//	public void addItem(CartItem item) {
//		addItem(item.getProduct(), item.getQuantity());
//	}
//	
//	public void addItem(Product product, int quantity) {
//		CartItem item = getItems(product);
//		if(item != null) {
//			item.setQuantity(item.getQuantity() + quantity);
//		}else {
//			item = new CartItem(product);
//			item.setQuantity(1);
//			items.add(item);
//		}
//	}
//	
//	public void updateItem(Product product, int quantity) {
//		CartItem item = getItems(product);
//		if(item != null) {
//			item.setQuantity(quantity);
//		}
//	}
//	
//	public void removeItem(Product product) {
//		CartItem item = getItems(product);
//		if(item != null)
//			items.remove(item);
//	}
//	
//	public void clear() {
//		items.clear();
//		total = 0;
//	}
//	
//	public boolean isEmpty() {
//		return items.isEmpty();
//	}
//
//	public double getTotal() {
//		for (CartItem cartItem : items) {
//			total = total + (cartItem.getSubTotal());
//		}
//		return total;
//	}
//
//	public void setTotal(double total) {
//		this.total = total;
//	}
//	
//}
