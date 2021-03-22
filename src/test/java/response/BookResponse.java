package response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookResponse {
    @JsonProperty("book_name")
    private String bookname;
    private String isbn;
    private String asile;
    private String author;



    public String getBookname()
    {
        return bookname;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public String getAsile()
    {
        return asile;
    }
    public String getAuthor()
    {
        return author;
    }

}
