package com.harshad.model;


  import java.util.List;
  
  import javax.persistence.CascadeType; import javax.persistence.Column; import
  javax.persistence.Entity; import javax.persistence.FetchType; import
  javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
  import javax.persistence.Id; import javax.persistence.JoinColumn; import
  javax.persistence.JoinTable; import javax.persistence.ManyToMany; import
  javax.persistence.Table; import javax.validation.constraints.Email; import
  javax.validation.constraints.NotEmpty;
  
  import lombok.Data;
  
  @Data
  
  @Entity
  
  @Table(name = "user")
  
  public class User {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.AUTO) private int id;
  
  @Column(name = "username", nullable = false) private String username;
  
  @Column(name = "phoneno") private String phoneno;
  
  @NotEmpty
  
  @Column(name = "email", unique = true, nullable = false)
  
  @Email(message = "{errors.invalid_email}") private String email;
  
  // @NotEmpty
  
  @Column(name = "password") private String password;
  
  // Roles
  
  @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  
  @JoinTable(
  
  name = "user_role", joinColumns = {
  
  @JoinColumn(name = "USER_ID", referencedColumnName = "ID") },
  inverseJoinColumns = {
  
  @JoinColumn(name = "Role_ID", referencedColumnName = "ID") }
  
  ) private List<Role> roles;
  
  // Parametric COnstructor
  
  public User(User user) {
  
  this.username = user.getUsername(); this.phoneno = user.getPhoneno();
  this.email = user.getEmail(); this.password = user.getPassword(); this.roles
  = user.getRoles(); }
  
  // Default COnstructor
  
  public User() { }
  
  public int getId() { return id; }
  
  public void setId(int id) { this.id = id; }
  
  public String getUsername() { return username; }
  
  public void setUsername(String username) { this.username = username; }
  
  public String getPhoneno() { return phoneno; }
  
  public void setPhoneno(String phoneno) { this.phoneno = phoneno; }
  
  public String getEmail() { return email; }
  
  public void setEmail(String email) { this.email = email; }
  
  public String getPassword() { return password; }
  
  public void setPassword(String password) { this.password = password; }
  
  public List<Role> getRoles() { return roles; }
  
  public void setRoles(List<Role> roles) { this.roles = roles; }

public void setEnabled(boolean b) {
}
  
  // Generate Getter And Setter Method
  
  }
 