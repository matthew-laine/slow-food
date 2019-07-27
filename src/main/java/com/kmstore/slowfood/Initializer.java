package com.kmstore.slowfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kmstore.slowfood.entities.Category;
import com.kmstore.slowfood.entities.Department;
import com.kmstore.slowfood.entities.Product;
import com.kmstore.slowfood.repositories.CategoryRepository;
import com.kmstore.slowfood.repositories.DepartmentRepository;
import com.kmstore.slowfood.repositories.ProductRepository;

@Component
public class Initializer implements CommandLineRunner{

	@Autowired
	DepartmentRepository deptRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public void run(String... args) throws Exception{
		System.out.println("RUNNING INITIALIZER");
		createDepartments();
		createCategories();
		createProducts();
	}

	private void createDepartments() {
		Department produce = new Department("produce");
		deptRepo.save(produce);
		Department meat = new Department("meat");
		deptRepo.save(meat);
		Department seafood = new Department("seafood");
		deptRepo.save(seafood);
		Department deli = new Department("deli");
		deptRepo.save(deli);
		Department cheese = new Department("cheese");
		deptRepo.save(cheese);
		Department dairy = new Department("dairy");
		deptRepo.save(dairy);
		Department bakery = new Department("bakery");
		deptRepo.save(bakery);
		Department frozen = new Department("frozen");
		deptRepo.save(frozen);
		Department packaged = new Department("packaged");
		deptRepo.save(packaged);
	}
	private void createCategories() {
		Category vegetables = new Category("vegetables", deptRepo.findByName("produce"));
		categoryRepo.save(vegetables);
		Category fruits = new Category("fruits", deptRepo.findByName("produce"));
		categoryRepo.save(fruits);
		Category leafyGreens = new Category("leafy-greens", deptRepo.findByName("produce"));
		categoryRepo.save(leafyGreens);
		
		Category pork = new Category("pork", deptRepo.findByName("meat"));
		categoryRepo.save(pork);
		Category beef = new Category("beef", deptRepo.findByName("meat"));
		categoryRepo.save(beef);
		Category poultry = new Category("poultry", deptRepo.findByName("meat"));
		categoryRepo.save(poultry);
		Category dried = new Category("dried", deptRepo.findByName("meat"));
		categoryRepo.save(dried);
	}
	
	private void createProducts() {
		Product strawberries = new Product("strawberries", "https://driscolls.imgix.net/-/media/images/pages/finest-berries/strawberries/modal/long-stem.ashx", categoryRepo.findByName("fruits"));
		productRepo.save(strawberries);
		Product tomatoes = new Product("tomatoes", "http://pngimg.com/uploads/tomato/tomato_PNG12567.png", categoryRepo.findByName("fruits"));
		productRepo.save(tomatoes);
		Product apples = new Product("apples", "https://images-na.ssl-images-amazon.com/images/I/91KlAVZ-mgL._SL1500_.jpg", categoryRepo.findByName("fruits"));
		productRepo.save(apples);
		Product pears = new Product("pears", "https://usapears.org/wp-content/uploads/2018/11/bosc-anjou.png", categoryRepo.findByName("fruits"));
		productRepo.save(pears);
		Product starfruits = new Product("starfruits", "http://bradburyycs.com/wp-content/uploads/2017/08/Star-fruit1.jpg", categoryRepo.findByName("fruits"));
		productRepo.save(starfruits);
		Product blueberries = new Product("blueberries", "https://www.medicalnewstoday.com/content/images/headlines/287/287710/blueberries.jpg", categoryRepo.findByName("fruits"));
		productRepo.save(blueberries);
		Product rasberies = new Product("rasberies", "https://target.scene7.com/is/image/Target/GUEST_6ac27504-1221-423b-9c0f-3a8d9be24b86?wid=488&hei=488&fmt=pjpeg", categoryRepo.findByName("fruits"));
		productRepo.save(rasberies);
//		Product tomatoes = new Product("", "", categoryRepo.findByName("fruits"));
//		productRepo.save();
		
		
		Product celery = new Product("celery", "https://i5.walmartimages.ca/images/Large/094/529/6000200094529.jpg", categoryRepo.findByName("vegetables"));
		productRepo.save(celery);
		Product asparagus = new Product("asparagus", "https://rasamalaysia.com/wp-content/uploads/2018/04/butter-sauteed-asparagus.jpg", categoryRepo.findByName("vegetables"));
		productRepo.save(asparagus);
		Product garlic = new Product("garlic", "http://www.cosmostotalhealth.org/wp-content/uploads/2017/03/garlic.jpg", categoryRepo.findByName("vegetables"));
		productRepo.save(garlic);
		Product parsnips = new Product("parsnips", "https://www.thespruceeats.com/thmb/6SRgfSeQF5NdzB0t1csjIEzWr9g=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/parsnips-g2k-56a8c1ff3df78cf772a05b87.jpg", categoryRepo.findByName("vegetables"));
		productRepo.save(parsnips);
		
		
		Product cabbage = new Product("cabbage", "https://s3.amazonaws.com/finecooking.s3.tauntonclud.com/app/uploads/2017/04/24172325/ING-green-cabbage-2-thumb1x1.jpg", categoryRepo.findByName("leafy-greens"));
		productRepo.save(cabbage);
		Product spinach = new Product("spinach", "https://img.purch.com/rc/300x200/aHR0cDovL3d3dy5saXZlc2NpZW5jZS5jb20vaW1hZ2VzL2kvMDAwLzA3Ni85MTYvb3JpZ2luYWwvc3BpbmFjaC5qcGc=", categoryRepo.findByName("vegetables"));
		productRepo.save(spinach);
		Product kale = new Product("kale", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Kale-Bundle.jpg/220px-Kale-Bundle.jpg", categoryRepo.findByName("leafy-greens"));
		productRepo.save(kale);
		Product lettuce = new Product("lettuce", "https://cdn.britannica.com/s:300x300/77/170677-004-75972A4C.jpg", categoryRepo.findByName("leafy-greens"));
		productRepo.save(lettuce);
		
	}
}
