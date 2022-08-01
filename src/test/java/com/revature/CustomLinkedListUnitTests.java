package com.revature;


import org.junit.jupiter.api.*;


//writing a unit test:
//arrange
//act
//assert

public class CustomLinkedListUnitTests {
    CustomLinkedList<Object> sut;

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }

    @BeforeEach
    void setup() {
        sut = new CustomLinkedList<>();
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    public void test_addObjectsToListAndVerifyOrder() {
        /*
        Arrange - create one or more objects to add to the list, and add them.
        Act - add one or more items to the list, then retrieve these items
        Assert - assert that the elements we added to the list are still present by asserting that those retrieved from the list
        are equal to what we added.
         */

        String str0 = "test";
        String str1 = "hello";
        String str2 = "world";

        sut.add(str0);
        sut.add(str1);
        sut.add(str2);

        String tst0 = (String)sut.get(0);
        String tst1 = (String)sut.get(1);
        String tst2 = (String)sut.get(2);

        Assertions.assertEquals(str0, tst0);
        Assertions.assertEquals(str1, tst1);
        Assertions.assertEquals(str2, tst2);


    }

    @Test
    public void test_iteratingOverCollectionUSingIterableInterface() {
        //arrange - create several elements to be added, consider order added as later it should match what we get out of the list.
        //act - add several elements to the list, use a for-each loop which depends on iterable implementation to work
        //assert - verify that the elements and order of elements is correct

        //arrange
        String[] input = new String[3];
        input[0] = "test";
        input[1] = "hello";
        input[2] = "world";

        //act
        sut.add(input[0]);
        sut.add(input[1]);
        sut.add(input[2]);

        //act/assert
        int i = 0;
        for(Object result : sut) {
            Assertions.assertEquals(input[i], result);
            i++;
        }

    }



    @Test
    public void test_causeIndexOutOfBoundsExceptionDueToNegativeIndex() {
        //arrange - instantiate an object to be added to the list
        //act - try to add an object to list at a negative index
        //assert assert that the IndexOutOfBounds exception is thrown

        String str = "hey!";

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {sut.add(-1, str);});
        /*
        This strange syntrax is called a lambda function, it's an anonymous ad-hoc function
         */
    }





}
