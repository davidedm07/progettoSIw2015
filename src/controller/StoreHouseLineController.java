package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Order;
import model.Product;
import model.StoreHouseLine;
import model.StoreHouseLineFacade;

@ManagedBean
public class StoreHouseLineController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Product product;
	private Long quantity;
	@ManagedProperty(value="#{param.idProdotto}")
	private Long idProdotto;
	private List<StoreHouseLine> storeHouseLines;
	@ManagedProperty(value="#{param.idOrdine}")
	private Long idOrdine;

	@EJB
	private StoreHouseLineFacade storeHouseLineFacade;
	
	public String createStoreHouseLine() {
		this.product=this.storeHouseLineFacade.getProduct(this.idProdotto);	
		this.storeHouseLineFacade.createStoreHouseLine(product, quantity);
		return "storeHouseLine";
	}
	
	public String findStoreHouseLine() {
		this.storeHouseLineFacade.getStoreHouseLine(id);
		return "storeHouseLine";
	}
	
	public String findAllStoreHouseLine() {
		this.storeHouseLines=this.storeHouseLineFacade.getAllStoreHouseLines();
		return "storeHouse";
		
	}
	
	public String updateStoreHouseLine() {
		StoreHouseLine str= this.storeHouseLineFacade.getStoreHouseLine(id);
		this.storeHouseLineFacade.updateStoreHouseLine(str,this.quantity);
		return "homepageAmministratore";
	}
	
	public String findProduct() {
		this.storeHouseLineFacade.getProduct(idProdotto);
		return "product";
	}
	
//	public String checkEvasionOrder() {
//		Order order=this.storeHouseLineFacade.findOrder(this.idOrdine);
//		this.storeHouseLineFacade.updateQuantities(order,this.id);
//		return "";
		
//	}
	
		
	// getters and setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Long idProdotto) {
		this.idProdotto = idProdotto;
	}

	public List<StoreHouseLine> getStoreHouseLines() {
		return storeHouseLines;
	}

	public void setStoreHouseLines(List<StoreHouseLine> storeHouseLines) {
		this.storeHouseLines = storeHouseLines;
	}

	public Long getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Long idOrdine) {
		this.idOrdine = idOrdine;
	}
	
	
	
	

}