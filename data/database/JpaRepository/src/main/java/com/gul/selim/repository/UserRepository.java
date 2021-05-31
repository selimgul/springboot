package com.gul.selim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.selim.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    // Query'de tablo adı yerine Entity adı kullanılmıştır.
    // Query case-sensitive çalışıyor. @Query kullanılmadığı durumda metod adı sonuna IgnoreCase eklenmesi yeterlidir.
    // @Query kullanılmış ise hem alan hem de parametre lower ya da upper ile eşleştirilmelidir.
    // JpaSpecificationExecutor ile mevcut JpaRepository metodlarına yenileri ekleniyor ve bu eklenen
    // metodlara Specification parametreleri verilerek  özelleştirilmiş ifadeler çalıştırılabilir.
    @Query(value = "SELECT u FROM User u where lower(u.name) like lower(concat(:name,'%'))")
    List<User> getByLikeIgnoreCase(@Param("name") String name);

    // nativeQuery = true ise verilen query SQL syntax'ındadır yani Entity adı yerine tablo adı kullanılır.
    @Query(value = "SELECT * FROM users u where u.name like :name%", nativeQuery = true)
    List<User> getByLikeNative(@Param("name") String name);

    List<User> findByName(String name);
    List<User> findByNameIgnoreCase(String name);
    List<User> findByNameIn(List<User> names);
    List<User> findByNameOrderByName(String name);
    List<User> findByNameAndId(String name, Integer Id);
}
