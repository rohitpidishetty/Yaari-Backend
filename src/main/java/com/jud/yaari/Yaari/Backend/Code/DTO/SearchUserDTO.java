package com.jud.yaari.Yaari.Backend.Code.DTO;

public class SearchUserDTO {
    public SearchUserDTO(String profilePicture, String username, String name, String bio) {
        this.profilePicture = profilePicture;
        this.username = username;
        this.name = name;
        this.bio = bio;
    }

    public String profilePicture, username, name , bio;

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
