package com.fdmgroup.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.fdmgroup.products.Item;

@Component
public class JpaItemDao implements ItemDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("omnistorage");

	@Override
	public List<Item> listItems() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Item> query = em.createQuery("SELECT u FROM User u", Item.class);
		List<Item> products = query.getResultList();
		em.close();
		return products;
	}

	@Override
	public void addItem(Item product) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Item getItem(String name) {
		EntityManager em = emf.createEntityManager();
		Item product = em.find(Item.class, name);
		em.close();
		return product;
	}

	@Override
	public void removeItem(String name) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Item.class, name));
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void updateItem(Item product) {
		EntityManager em = emf.createEntityManager();
		Item itemInDb = em.find(Item.class, product.getItem_id());
		em.getTransaction().begin();

		itemInDb.setName(product.getName());
		itemInDb.setColor(product.getColor());
		itemInDb.setPrice(product.getPrice());

		em.getTransaction().commit();
		em.close();
	}

}
