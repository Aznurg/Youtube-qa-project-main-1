package MyAPITest;

import java.util.ArrayList;

public class Root {
    private int id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private String status;

    public Root(int id, Category category, String name, ArrayList<String> photoUrls, ArrayList<Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
    public Root(){}

    class Category {
        private int id;
        private String catName;
        public Category(int id, String catName){
            this.id = id;
            this.catName = catName;
        }
    }


    class Tag{
        private int id;
        private String tagName;
        public Tag(int id, String tagName){
            this.id = id;
            this.tagName = tagName;
        }
    }



    public int getId() {
        return id;}
    public Category getCategory() {
        return category;}
    public String getName() {
        return name;}
    public ArrayList<String> getPhotoUrls() {
        return photoUrls;}
    public ArrayList<Tag> getTags() {
        return tags;}
    public String getStatus() {
        return status;}

    public void setId(int id) {
        this.id = id;}
    public void setCategory(Category category) {
        this.category = category;}
    public void setName(String name) {
        this.name = name;}
    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;}
    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;}
    public void setStatus(String status) {
        this.status = status;}
}