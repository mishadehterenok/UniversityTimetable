package by.mdhtrnk.demouniversity.service;

import by.mdhtrnk.demouniversity.util.DataImporter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class BaseTest{

//    @Autowired
//    private DataImporter importer;
//
//    @BeforeEach
//    void initDb(){
//        importer.importTestData();
//    }

    abstract void testFindAll();
    abstract void testSave();
    abstract void testFindById();
    abstract void testUpdate();
}
