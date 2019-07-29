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
		Department deli = new Department("deli");
		deptRepo.save(deli);
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

//      deli
		Category deliBeef = new Category("deli beef", deptRepo.findByName("deli"));
		categoryRepo.save(deliBeef);
		Category deliHam = new Category("deli ham", deptRepo.findByName("deli"));
		categoryRepo.save(deliHam);
		Category deliTurkey = new Category("deli turkey", deptRepo.findByName("deli"));
		categoryRepo.save(deliTurkey);
		Category deliChicken = new Category("deli chicken", deptRepo.findByName("deli"));
		categoryRepo.save(deliChicken);
	}

	private void createProducts() {
//		PRODUCE
//		fruits
		Product strawberries = new Product("strawberries", "$3.99/lb", "https://hips.hearstapps.com/ghk.h-cdn.co/assets/cm/15/11/54fe493d07a7a-ghk-stainbuster-strawberry-mdn-98120767.jpg", categoryRepo.findByName("fruits"));
		productRepo.save(strawberries);
		Product tomatoes = new Product("tomatoes", "$0.69/lb", "http://pngimg.com/uploads/tomato/tomato_PNG12567.png", categoryRepo.findByName("fruits"));
		productRepo.save(tomatoes);
		Product apples = new Product("apples", "$1.00/lb", "https://images-na.ssl-images-amazon.com/images/I/91KlAVZ-mgL._SL1500_.jpg", categoryRepo.findByName("fruits"));
		productRepo.save(apples);
		Product pears = new Product("pears", "1.99/lb", "https://usapears.org/wp-content/uploads/2018/11/bosc-anjou.png", categoryRepo.findByName("fruits"));
		productRepo.save(pears);
		Product starfruits = new Product("starfruits", "$4.99/lb", "http://bradburyycs.com/wp-content/uploads/2017/08/Star-fruit1.jpg", categoryRepo.findByName("fruits"));
		productRepo.save(starfruits);
		Product blueberries = new Product("blueberries", "$3.99/lb", "https://www.medicalnewstoday.com/content/images/headlines/287/287710/blueberries.jpg", categoryRepo.findByName("fruits"));
		productRepo.save(blueberries);
		Product raspberries = new Product("raspberries", "$3.99/lb", "https://target.scene7.com/is/image/Target/GUEST_6ac27504-1221-423b-9c0f-3a8d9be24b86?wid=488&hei=488&fmt=pjpeg", categoryRepo.findByName("fruits"));
		productRepo.save(raspberries);
		
//		vegetables
		Product celery = new Product("celery", "$0.89/lb", "https://i5.walmartimages.ca/images/Large/094/529/6000200094529.jpg", categoryRepo.findByName("vegetables"));
		productRepo.save(celery);
		Product asparagus = new Product("asparagus", "$1.39/lb", "https://rasamalaysia.com/wp-content/uploads/2018/04/butter-sauteed-asparagus.jpg", categoryRepo.findByName("vegetables"));
		productRepo.save(asparagus);
		Product garlic = new Product("garlic", "$5.79/lb", "http://www.cosmostotalhealth.org/wp-content/uploads/2017/03/garlic.jpg", categoryRepo.findByName("vegetables"));
		productRepo.save(garlic);
		Product parsnips = new Product("parsnips", "$1.29/lb", "https://www.thespruceeats.com/thmb/6SRgfSeQF5NdzB0t1csjIEzWr9g=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/parsnips-g2k-56a8c1ff3df78cf772a05b87.jpg", categoryRepo.findByName("vegetables"));
		productRepo.save(parsnips);

//		leafy-greens
		Product cabbage = new Product("cabbage", "$0.39/lb", "https://s3.amazonaws.com/finecooking.s3.tauntonclud.com/app/uploads/2017/04/24172325/ING-green-cabbage-2-thumb1x1.jpg", categoryRepo.findByName("leafy-greens"));
		productRepo.save(cabbage);
		Product spinach = new Product("spinach", "$0.79/lb", "https://img.purch.com/rc/300x200/aHR0cDovL3d3dy5saXZlc2NpZW5jZS5jb20vaW1hZ2VzL2kvMDAwLzA3Ni85MTYvb3JpZ2luYWwvc3BpbmFjaC5qcGc=", categoryRepo.findByName("leafy-greens"));
		productRepo.save(spinach);
		Product kale = new Product("kale", "$0.79/lb", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Kale-Bundle.jpg/220px-Kale-Bundle.jpg", categoryRepo.findByName("leafy-greens"));
		productRepo.save(kale);
		Product lettuce = new Product("lettuce", "$0.49/lb", "https://cdn.britannica.com/s:300x300/77/170677-004-75972A4C.jpg", categoryRepo.findByName("leafy-greens"));
		productRepo.save(lettuce);

//		MEAT
//		pork
		Product bacon = new Product("bacon", "$2.99/lb", "http://www.foodnutritiontable.com/_lib/img/prod/big/ontbijtspek.jpg", categoryRepo.findByName("pork"));
		productRepo.save(bacon);
		Product porkChops = new Product("pork chops", "$2.99/lb", "https://www.barfblog.com/wp-content/uploads/2011/06/pork_chop_raw.jpg", categoryRepo.findByName("pork"));
		productRepo.save(porkChops);
		Product porkloin = new Product("porkloin", "$2.99/lb", "https://image.shutterstock.com/image-photo/raw-pork-fillet-isolated-on-260nw-463142702.jpg", categoryRepo.findByName("pork"));
		productRepo.save(porkloin);
		
//		beef
		Product burgerPatty = new Product("burger patty", "$1.99/lb", "https://s3.envato.com/files/248946677/38743_.jpg", categoryRepo.findByName("beef"));
		productRepo.save(burgerPatty);
		Product steak = new Product("steak", "$8.99/lb", "http://www.topratedsteakhouses.com/wp-content/uploads/2013/11/Raw-Rib-Eye-e1384445199924.jpg", categoryRepo.findByName("beef"));
		productRepo.save(steak);
		Product beefRibs = new Product("beef ribs", "$3.99/lb", "https://images-na.ssl-images-amazon.com/images/I/81Uwv1R1zSL._AC._SR360,460.jpg", categoryRepo.findByName("beef"));
		productRepo.save(beefRibs);
		Product roundSteak = new Product("round steak", "$3.99/lb", "https://cdn.shopify.com/s/files/1/1463/5240/products/top_round_steak_burned_large.png?v=1477316242", categoryRepo.findByName("beef"));
		productRepo.save(roundSteak);
		
//		poultry
		Product wholeTurkey = new Product("whole turkey", "$1.49/lb", "https://www.freepngimg.com/thumb/meat/33503-6-chicken-meat-transparent-background.png", categoryRepo.findByName("poultry"));
		productRepo.save(wholeTurkey);
		Product wholeChicken = new Product("whole chicken", "$0.99/lb", "http://www.m-tradegroup.com/wp-content/uploads/2017/04/22739276_s.jpg", categoryRepo.findByName("poultry"));
		productRepo.save(wholeChicken);
		Product wholeGoose = new Product("whole goose", "$6.99/lb", "https://c7.uihere.com/files/165/456/62/chicken-fingers-chicken-leg-chicken-meat-roast-chicken-chicken-meat-transparent-background.jpg", categoryRepo.findByName("poultry"));
		productRepo.save(wholeGoose);
		Product wholeDuck = new Product("whole duck", "$7.99/lb", "https://www.trzcacak.rs/myfile/detail/31-318516_download-chicken-meat-png-images-background-broiler-chicken.png", categoryRepo.findByName("poultry"));
		productRepo.save(wholeDuck);
		
//		DELI
//		deliBeef
		Product londonBroil = new Product("london broil", "$9.99/lb", "https://www.wegmans.com/content/dam/wegmans/products/720/629720.jpg", categoryRepo.findByName("deli beef"));
		productRepo.save(londonBroil);
		Product slowRoastBeef = new Product("slow roast beef", "$8.99/lb", "https://chefsavvy.com/wp-content/uploads/Oven-Roasted-Beef-Brisket.jpg", categoryRepo.findByName("deli beef"));
		productRepo.save(slowRoastBeef);
		Product cajuanRoastBeef = new Product("cajuan roast beef", "$6.99/lb", "https://cutpcdnwimages.azureedge.net/images/products/95000/097684-75x75-B.jpg", categoryRepo.findByName("deli beef"));
		productRepo.save(cajuanRoastBeef);
		
//		deliHam
		Product goldenHam = new Product("golden ham", "$5.99/lb", "https://www.dorsogna.com.au/assets/Uploads/_resampled/CroppedFocusedImageWyIzMjAiLCIzNDAiLCJ4Iiw0Ml0/9694-Traditional-Golden-Roast-Leg-Ham.png", categoryRepo.findByName("deli ham"));
		productRepo.save(goldenHam);
		Product blackForestHam = new Product("black forest ham", "$5.99/lb", "https://images-na.ssl-images-amazon.com/images/I/61F-oMTcApL._SX355_.jpg", categoryRepo.findByName("deli ham"));
		productRepo.save(blackForestHam);
		Product hamOffTheBone = new Product("ham off the bone", "$4.49/lb", "https://images-na.ssl-images-amazon.com/images/I/31vT6uGiZuL.jpg", categoryRepo.findByName("deli ham"));
		productRepo.save(hamOffTheBone);
		Product mapleHam = new Product("maple ham", "$6.99/lb", "http://www.thegrocerygirls.com/media/catalog/product/cache/1/small_image/350x/9df78eab33525d08d6e5fb8d27136e95/4/G/4G01B.jpg.jpg", categoryRepo.findByName("deli ham"));
		productRepo.save(mapleHam);
		Product honeyHam = new Product("honey ham", "$5.99/lb", "https://doublejgulf.com/image/cache/catalog/deli-ham%20-%20448A-500x500.jpg", categoryRepo.findByName("deli ham"));
		productRepo.save(honeyHam);
		Product cajuanHam = new Product("cajuan ham", "$5.99/lb", "https://www.recipe4living.com/assets/itemimages/400/400/3/default_c8bb19b2fc82210b47adea72cf253ca3_Cajun-Style-Dry-Rubbed-Ham.jpg", categoryRepo.findByName("deli ham"));
		productRepo.save(cajuanHam);
		
//		deliTurkey
		Product goldenTurkey = new Product("golden turkey", "$5.99/lb", "http://www.miturkey.com/uploads/images/Content/RTC.png", categoryRepo.findByName("deli turkey"));
		productRepo.save(goldenTurkey);
		Product honeyTurkey = new Product("honey turkey", "$6.99/lb", "https://i5.walmartimages.com/asr/b2e06ce5-08ea-4e34-b66a-26a1742708ec_1.7223a60bb44a788f72fe480b6063a57c.jpeg?odnHeight=450&odnWidth=450&odnBg=FFFFFF", categoryRepo.findByName("deli turkey"));
		productRepo.save(honeyTurkey);
		Product blackForestTurkey = new Product("black forest turkey", "$6.99/lb", "https://images-na.ssl-images-amazon.com/images/I/814ctc2FuKL._SX355_.jpg", categoryRepo.findByName("deli turkey"));
		productRepo.save(blackForestTurkey);
		Product ovenClassicTurkey = new Product("oven classic turkey", "$3.99/lb", "https://s7d5.scene7.com/is/image/CentralMarket/001274365-1?$large$&hei=416&wid=416", categoryRepo.findByName("deli turkey"));
		productRepo.save(ovenClassicTurkey);
		Product mapleTurkey = new Product("maple turkey", "$3.99/lb", "https://images-na.ssl-images-amazon.com/images/I/3196k38sReL.jpg", categoryRepo.findByName("deli turkey"));
		productRepo.save(mapleTurkey);
		
//		deliChicken
		Product ovenChicken = new Product("oven chicken", "$4.99/lb", "https://i5.walmartimages.com/asr/1e6021ba-f993-4224-9e02-f1b7ed8f8f6c_1.00872be702396af8fd23c3ece0027c29.jpeg?odnHeight=450&odnWidth=450&odnBg=FFFFFF", categoryRepo.findByName("deli chicken"));
		productRepo.save(ovenChicken);
		Product buffaloChicken = new Product("buffalo chicken", "$3.99/lb", "https://cutpcdnwimages.azureedge.net/images/products/10000/013816-75x75-B.jpg", categoryRepo.findByName("deli chicken"));
		productRepo.save(buffaloChicken);
	}
}
