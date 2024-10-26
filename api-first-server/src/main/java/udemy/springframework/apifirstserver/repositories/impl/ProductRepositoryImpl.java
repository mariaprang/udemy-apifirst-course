package udemy.springframework.apifirstserver.repositories.impl;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Repository;
import udemy.springframework.apifirstserver.repositories.ProductRepository;
import udemy.springframework.model.Category;
import udemy.springframework.model.Dimensions;
import udemy.springframework.model.Image;
import udemy.springframework.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<UUID, Product> entityMap = new HashMap<>();

    @Override
    public <S extends Product> S save(S entity) {
        UUID id = UUID.randomUUID();

        Product.ProductBuilder builder1 = Product.builder();

        builder1.id(id);

        if (entity.getDimensions() != null) {
            builder1.dimensions(Dimensions.builder()
                .length(entity.getDimensions().getLength())
                .width(entity.getDimensions().getWidth())
                .height(entity.getDimensions().getHeight())
                .description("Product Dimensions")
                .build());
        }
        if (entity.getCategories() != null) {
            builder1.categories(entity.getCategories().stream().map(category -> Category.builder()
                .id(UUID.randomUUID())
                .category(category.getCategory())
                .description(category.getDescription())
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build()).collect(Collectors.toList()));
        }
        if (entity.getImages() != null) {
            builder1.images(entity.getImages().stream().map(image -> Image.builder()
                .id(UUID.randomUUID())
                .url(image.getUrl())
                .altText(image.getAltText())
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build()).collect(Collectors.toList()));
        }
        Product product = builder1.title(entity.getTitle())
            .cost(entity.getCost())
            .price(entity.getPrice())
            .build();

        entityMap.put(id, product);

        return (S) product;
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
            .map(this::save)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(UUID uuid) {
        return Optional.of(entityMap.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return entityMap.get(uuid) != null;
    }

    @Override
    public Iterable<Product> findAll() {
        return entityMap.values();
    }

    @Override
    public Iterable<Product> findAllById(Iterable<UUID> uuids) {
        return StreamSupport.stream(uuids.spliterator(), false)
            .map(this::findById)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return entityMap.size();
    }

    @Override
    public void deleteById(UUID uuid) {
        entityMap.remove(uuid);
    }

    @Override
    public void delete(Product entity) {
        entityMap.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {
        uuids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        entityMap.clear();
    }
}