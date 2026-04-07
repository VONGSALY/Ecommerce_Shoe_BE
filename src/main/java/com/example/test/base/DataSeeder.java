package com.example.test.base;

import com.example.test.entity.*;
import com.example.test.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final BrandsRepository brandsRepository;
    private final CategoryRepository categoryRepository;
    private final SalesRepository salesRepository;
    private final VoucherRepository voucherRepository;
    private final ImageRepository imageRepository;
    private final AttributeRepository attributeRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Đang dọn dẹp dữ liệu cũ...");
        productCategoryRepository.deleteAll();
        attributeRepository.deleteAll();
        imageRepository.deleteAll();
        productRepository.deleteAll();
        brandsRepository.deleteAll();
        categoryRepository.deleteAll();
        salesRepository.deleteAll();
        voucherRepository.deleteAll();

        if (brandsRepository.count() == 0) {
            System.out.println("Bắt đầu khởi tạo Brands, Categories, Sales...");

            // 1. Thêm Brands
            Brands nike = createBrand("Nike", "Thương hiệu thể thao hàng đầu thế giới");
            Brands adidas = createBrand("Adidas", "Sự lựa chọn hoàn hảo cho thể thao và thời trang");
            Brands puma = createBrand("Puma", "Đậm chất thể thao đường phố");
            Brands vans = createBrand("Vans", "Giày trượt ván được ưa chuộng toàn cầu");
            Brands converse = createBrand("Converse", "Biểu tượng thời trang qua nhiều thế hệ");
            List<Brands> brands = Arrays.asList(nike, adidas, puma, vans, converse);

            // 2. Thêm Categories
            Category running = createCategory("Running", "Giày chạy bộ chuyên nghiệp");
            Category sneaker = createCategory("Sneaker", "Giày thời trang đường phố");
            Category basketball = createCategory("Basketball", "Giày bóng rổ");
            Category walking = createCategory("Walking", "Giày đi bộ thoải mái");
            List<Category> categories = Arrays.asList(running, sneaker, basketball, walking);

            // 3. Thêm Sales
            Sales noSale = createSale("Không giảm giá", 0L);
            Sales summerSale = createSale("Summer Sale", 10L);
            Sales flashSale = createSale("Flash Sale", 30L);
            List<Sales> salesList = Arrays.asList(noSale, summerSale, flashSale, noSale, noSale); // 60% tỉ lệ không giảm

            // 4. Thêm Vouchers
            createVoucher("WELCOME10", 10L, 100L);
            createVoucher("SUPER30", 30L, 50L);
            createVoucher("MEGA50", 50L, 10L);

            System.out.println("Đã chèn cơ sở thành công! Product sẽ được chèn qua Script ngoài.");
        }
    }

    private Brands createBrand(String name, String desc) {
        Brands b = new Brands();
        b.setName(name);
        b.setDescription(desc);
        b.setCreateDate(LocalDate.now());
        b.setModifyDate(LocalDate.now());
        b.setIsActive(true);
        return brandsRepository.save(b);
    }

    private Category createCategory(String name, String desc) {
        Category c = new Category();
        c.setName(name);
        c.setDescription(desc);
        c.setCreateDate(LocalDate.now());
        c.setModifyDate(LocalDate.now());
        c.setIsActive(true);
        return categoryRepository.save(c);
    }

    private Sales createSale(String name, Long discount) {
        Sales s = new Sales();
        s.setName(name);
        s.setDiscount(discount);
        s.setCreateDate(LocalDate.now());
        s.setModifyDate(LocalDate.now());
        s.setIsActive(true);
        return salesRepository.save(s);
    }

    private void createVoucher(String code, Long discount, Long count) {
        Voucher v = new Voucher();
        v.setCode(code);
        v.setDiscount(discount);
        v.setCount(count);
        v.setCreateDate(LocalDate.now());
        v.setExpireDate(LocalDate.now().plusMonths(3));
        v.setIsActive(true);
        voucherRepository.save(v);
    }

    private void createImage(Long productId, String name, String link) {
        Image img = new Image();
        img.setProductId(productId);
        img.setName(name);
        img.setImageLink(link);
        img.setCreateDate(LocalDate.now());
        img.setModifyDate(LocalDate.now());
        img.setIsActive(true);
        imageRepository.save(img);
    }

    private void createAttribute(Long productId, String name, Long size, Double price, Long stock) {
        Attribute attr = new Attribute();
        attr.setProductId(productId);
        attr.setName(name);
        attr.setSize(size);
        attr.setPrice(price);
        attr.setStock(stock);
        attr.setCache(0L);
        attr.setCreateDate(LocalDate.now());
        attr.setModifyDate(LocalDate.now());
        attributeRepository.save(attr);
    }
}
