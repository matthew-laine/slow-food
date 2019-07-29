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
public class Initializer implements CommandLineRunner {

	@Autowired
	DepartmentRepository deptRepo;

	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	ProductRepository productRepo;

	@Override
	public void run(String... args) throws Exception {
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
//		produce
		Category vegetables = new Category("vegetables", deptRepo.findByName("produce"));
		categoryRepo.save(vegetables);
		Category fruits = new Category("fruits", deptRepo.findByName("produce"));
		categoryRepo.save(fruits);
		Category leafyGreens = new Category("leafy-greens", deptRepo.findByName("produce"));
		categoryRepo.save(leafyGreens);

//		meat
		Category pork = new Category("pork", deptRepo.findByName("meat"));
		categoryRepo.save(pork);
		Category beef = new Category("beef", deptRepo.findByName("meat"));
		categoryRepo.save(beef);
		Category poultry = new Category("poultry", deptRepo.findByName("meat"));
		categoryRepo.save(poultry);
		Category dried = new Category("dried", deptRepo.findByName("meat"));
		categoryRepo.save(dried);

//		seafood
		Category fish = new Category("fish", deptRepo.findByName("seafood"));
		categoryRepo.save(fish);
		Category roe = new Category("roe", deptRepo.findByName("seafood"));
		categoryRepo.save(roe);
		Category shellfish = new Category("shellfish", deptRepo.findByName("seafood"));
		categoryRepo.save(shellfish);

//      deli
		Category deliBeef = new Category("deliBeef", deptRepo.findByName("deli"));
		categoryRepo.save(deliBeef);

//		Category deli = new Category("deli", deptRepo.findByName("seafood"));
//		categoryRepo.save(deli);
	}

	private void createProducts() {
//		PRODUCE
//		fruits
		Product strawberries = new Product("strawberries",
				"https://driscolls.imgix.net/-/media/images/pages/finest-berries/strawberries/modal/long-stem.ashx",
				categoryRepo.findByName("fruits"));
		productRepo.save(strawberries);
		Product tomatoes = new Product("tomatoes", "http://pngimg.com/uploads/tomato/tomato_PNG12567.png",
				categoryRepo.findByName("fruits"));
		productRepo.save(tomatoes);
		Product apples = new Product("apples",
				"https://images-na.ssl-images-amazon.com/images/I/91KlAVZ-mgL._SL1500_.jpg",
				categoryRepo.findByName("fruits"));
		productRepo.save(apples);
		Product pears = new Product("pears", "https://usapears.org/wp-content/uploads/2018/11/bosc-anjou.png",
				categoryRepo.findByName("fruits"));
		productRepo.save(pears);
		Product starfruits = new Product("starfruits",
				"http://bradburyycs.com/wp-content/uploads/2017/08/Star-fruit1.jpg", categoryRepo.findByName("fruits"));
		productRepo.save(starfruits);
		Product blueberries = new Product("blueberries",
				"https://www.medicalnewstoday.com/content/images/headlines/287/287710/blueberries.jpg",
				categoryRepo.findByName("fruits"));
		productRepo.save(blueberries);
		Product rasberies = new Product("rasberies",
				"https://target.scene7.com/is/image/Target/GUEST_6ac27504-1221-423b-9c0f-3a8d9be24b86?wid=488&hei=488&fmt=pjpeg",
				categoryRepo.findByName("fruits"));
		productRepo.save(rasberies);
//		Product tomatoes = new Product("", "", categoryRepo.findByName("fruits"));
//		productRepo.save();

//		vegetables
		Product celery = new Product("celery", "https://i5.walmartimages.ca/images/Large/094/529/6000200094529.jpg",
				categoryRepo.findByName("vegetables"));
		productRepo.save(celery);
		Product asparagus = new Product("asparagus",
				"https://rasamalaysia.com/wp-content/uploads/2018/04/butter-sauteed-asparagus.jpg",
				categoryRepo.findByName("vegetables"));
		productRepo.save(asparagus);
		Product garlic = new Product("garlic", "http://www.cosmostotalhealth.org/wp-content/uploads/2017/03/garlic.jpg",
				categoryRepo.findByName("vegetables"));
		productRepo.save(garlic);
		Product parsnips = new Product("parsnips",
				"https://www.thespruceeats.com/thmb/6SRgfSeQF5NdzB0t1csjIEzWr9g=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/parsnips-g2k-56a8c1ff3df78cf772a05b87.jpg",
				categoryRepo.findByName("vegetables"));
		productRepo.save(parsnips);

//		leafy-greens
		Product cabbage = new Product("cabbage",
				"https://s3.amazonaws.com/finecooking.s3.tauntonclud.com/app/uploads/2017/04/24172325/ING-green-cabbage-2-thumb1x1.jpg",
				categoryRepo.findByName("leafy-greens"));
		productRepo.save(cabbage);
		Product spinach = new Product("spinach",
				"https://img.purch.com/rc/300x200/aHR0cDovL3d3dy5saXZlc2NpZW5jZS5jb20vaW1hZ2VzL2kvMDAwLzA3Ni85MTYvb3JpZ2luYWwvc3BpbmFjaC5qcGc=",
				categoryRepo.findByName("vegetables"));
		productRepo.save(spinach);
		Product kale = new Product("kale",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Kale-Bundle.jpg/220px-Kale-Bundle.jpg",
				categoryRepo.findByName("leafy-greens"));
		productRepo.save(kale);
		Product lettuce = new Product("lettuce", "https://cdn.britannica.com/s:300x300/77/170677-004-75972A4C.jpg",
				categoryRepo.findByName("leafy-greens"));
		productRepo.save(lettuce);

//		MEAT
//		pork
		Product blackForestHam = new Product("black forest ham",
				"https://images-na.ssl-images-amazon.com/images/I/61F-oMTcApL._SX355_.jpg",
				categoryRepo.findByName("pork"));
		productRepo.save(blackForestHam);
		Product hamOffTheBone = new Product("ham off the bone",
				"https://images-na.ssl-images-amazon.com/images/I/31vT6uGiZuL.jpg", categoryRepo.findByName("pork"));
		productRepo.save(hamOffTheBone);
		Product bacon = new Product("bacon", "http://www.foodnutritiontable.com/_lib/img/prod/big/ontbijtspek.jpg",
				categoryRepo.findByName("pork"));
		productRepo.save(bacon);
		Product porkRibs = new Product("pork ribs", "https://cdn.shopify.com/s/files/1/0891/7528/products/IMG_2591_large.JPG?v=1512479880", categoryRepo.findByName("pork"));
		productRepo.save(porkRibs);
		Product porkChops = new Product("pork chops",
				"https://www.barfblog.com/wp-content/uploads/2011/06/pork_chop_raw.jpg",
				categoryRepo.findByName("pork"));
		productRepo.save(porkChops);
		Product porkloin = new Product("porkloin",
				"https://image.shutterstock.com/image-photo/raw-pork-fillet-isolated-on-260nw-463142702.jpg",
				categoryRepo.findByName("pork"));
		productRepo.save(porkloin);

//		beef
		Product burgerPatty = new Product("burger patty", "https://s3.envato.com/files/248946677/38743_.jpg",
				categoryRepo.findByName("beef"));
		productRepo.save(burgerPatty);
		Product steak = new Product("steak",
				"http://www.topratedsteakhouses.com/wp-content/uploads/2013/11/Raw-Rib-Eye-e1384445199924.jpg",
				categoryRepo.findByName("beef"));
		productRepo.save(steak);
		Product beefRibs = new Product("beef ribs",
				"https://images-na.ssl-images-amazon.com/images/I/81Uwv1R1zSL._AC._SR360,460.jpg",
				categoryRepo.findByName("beef"));
		productRepo.save(beefRibs);
		Product roundSteak = new Product("round steak",
				"https://cdn.shopify.com/s/files/1/1463/5240/products/top_round_steak_burned_large.png?v=1477316242",
				categoryRepo.findByName("beef"));
		productRepo.save(roundSteak);

//		poultry
		Product whokeTurkey = new Product("whole turkey",
				"https://www.freepngimg.com/thumb/meat/33503-6-chicken-meat-transparent-background.png",
				categoryRepo.findByName("poultry"));
		productRepo.save(whokeTurkey);
		Product wholeChicken = new Product("whole chicken",
				"http://www.m-tradegroup.com/wp-content/uploads/2017/04/22739276_s.jpg",
				categoryRepo.findByName("poultry"));
		productRepo.save(wholeChicken);
		Product wholeGoose = new Product("whole goose",
				"https://c7.uihere.com/files/165/456/62/chicken-fingers-chicken-leg-chicken-meat-roast-chicken-chicken-meat-transparent-background.jpg",
				categoryRepo.findByName("poultry"));
		productRepo.save(wholeGoose);
		Product wholeDuck = new Product("whole duck",
				"https://www.trzcacak.rs/myfile/detail/31-318516_download-chicken-meat-png-images-background-broiler-chicken.png",
				categoryRepo.findByName("poultry"));
		productRepo.save(wholeDuck);
		Product goldenTurkey = new Product("golden turkey", "http://www.miturkey.com/uploads/images/Content/RTC.png",
				categoryRepo.findByName("poultry"));
		productRepo.save(goldenTurkey);

//		dried
		Product beefJerky = new Product("beef jerky",
				"https://www.passionvines.com/images/sites/passionvines/labels/jerky-james-beef-jerky_1.jpg",
				categoryRepo.findByName("dried"));
		productRepo.save(beefJerky);
		Product porkJerky = new Product("pork jerky",
				"http://static1.squarespace.com/static/59c9520cd2b8576ab72c1684/5b7d7c76562fa73ad483af23/5b7d7fee89858327ce74f003/1561731528800/?format=1500w",
				categoryRepo.findByName("dried"));
		productRepo.save(porkJerky);
		Product turkeyJerky = new Product("turkey jerky",
				"https://www.passionvines.com/images/sites/passionvines/labels/jerky-james-turkey-jerky_1.jpg",
				categoryRepo.findByName("dried"));
		productRepo.save(turkeyJerky);
		Product pancetta = new Product("pancetta",
				"https://s3.amazonaws.com/finecooking.s3.tauntonclud.com/app/uploads/2017/04/24171655/ING-pancetta-thumb1x1.jpg",
				categoryRepo.findByName("dried"));
		productRepo.save(pancetta);
		Product alligatorJerky = new Product("alligator jerkey",
				"https://images-na.ssl-images-amazon.com/images/I/91jZ5uwrt2L._SX355_.jpg",
				categoryRepo.findByName("dried"));
		productRepo.save(alligatorJerky);

//		Product  = new Product("", "", categoryRepo.findByName(""));
//		productRepo.save();
//		Product  = new Product("", "", categoryRepo.findByName(""));
//		productRepo.save();
//		Product  = new Product("", "", categoryRepo.findByName(""));
//		productRepo.save();
//		Product  = new Product("", "", categoryRepo.findByName(""));
//		productRepo.save();
//		Product  = new Product("", "", categoryRepo.findByName(""));
//		productRepo.save();

	}
}
