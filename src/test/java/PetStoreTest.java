import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PetStoreTest extends BaseTest {

    // Json formatında strıng oluşturma
    String newPet = """
        {
          "id": 12345,
          "category": {
            "id": 1,
            "name": "Dogs"
          },
          "name": "Doggie",
          "photoUrls": [
            "https://example.com/photo.jpg"
          ],
          "tags": [
            {
              "id": 1,
              "name": "friendly"
            }
          ],
          "status": "available"
        }
    """;

    // yeni pett
    @Test(priority = 1)
    public void createPet() {
        given()
                .contentType(ContentType.JSON)
                .body(newPet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo(12345))
                .body("name", equalTo("Doggie"))
                .body("status", equalTo("available"))
                .body("category.name", equalTo("Dogs"))
                .body("tags[0].name", equalTo("friendly"));
    }

    // 2. Id si ile diğer detaylara ulaşma
    @Test(priority = 2)
    public void getPetById() {
        given()
                .pathParam("petId", 12345)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(12345))
                .body("name", equalTo("Doggie"))
                .body("status", equalTo("available"));
    }

    // 3. PUT: Pet'in durumunu güncelle
    @Test(priority = 3)
    public void updatePetStatus() {
        String updatedPet = """
            {
              "id": 12345,
              "category": {
                "id": 1,
                "name": "Dogs"
              },
              "name": "Doggie",
              "photoUrls": [
                "https://example.com/photo.jpg"
              ],
              "tags": [
                {
                  "id": 1,
                  "name": "friendly"
                }
              ],
              "status": "not avaliable"
            }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(updatedPet)
                .when()
                .put("/pet")
                .then()
                .statusCode(200)
                .body("status", equalTo("not avaliable"));
    }

    // 4. DELETE ile pet'i sil
    @Test(priority = 4)
    public void deletePet() {
        given()
                .pathParam("petId", 12345)
                .when()
                .delete("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("message", equalTo("12345"));
    }

    //  Silinen pet get ile bakma
    @Test(priority = 5)
    public void getDeletedPet() {
        given()
                .pathParam("petId", 12345)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(404)
                .body("message", equalTo("Pet not found"));
    }
}
