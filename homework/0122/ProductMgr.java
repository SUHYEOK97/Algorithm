package hwjava05_광주_3반_김수혁;

public class ProductMgr {
	private static ProductMgr instance;
	public static ProductMgr getInstance() {
		if(instance==null) instance = new ProductMgr();
		return instance;
	}
	private final int MAX_IDX = 100;
	private Product[] products;
	private int idx = 0;
	
	public ProductMgr() {
		products = new Product[MAX_IDX];
	}

	public void add(Product p) {
		products[idx] = p;
		idx++;
	}
	
	public Product[] list() {
		Product[] tmp = new Product[idx];
		for(int i=0; i<idx; i++) tmp[i] = products[i];
		return tmp;
	}
	
	public Product list(int num) {
		for(int i=0; i<idx; i++) {
			if(products[i].getId() == num) {
				return products[i];
			}
		}
		return null;
	}
	
	public void delete(int num) {
		for(int i=0; i<idx; i++) {
			if(products[i].getId()==num) {
				for(int j=i+1; j<idx; j++) {
					products[j-1] = products[j];
				}
				idx--;
				break;
			}
		}
	}
	
	public Product[] priceList(int price) {
		Product[] tmp = null;
		int[] arr = new int[MAX_IDX];
		int arrIdx = 0;
		for(int i=0; i<idx; i++) {
			if(products[i].getPrice() <= price) {
				arr[arrIdx++] = i;
			}
		}
		tmp = new Product[arrIdx];
		for(int i=0; i<arrIdx; i++) tmp[i] = products[arr[i]]; 
		return tmp;
	}

}
