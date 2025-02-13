package ai.recruit.testrecruit.web;

import ai.recruit.testrecruit.dto.*;
import ai.recruit.testrecruit.service.ICompanyService;
import ai.recruit.testrecruit.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@CrossOrigin("*")
public class Controller {

    private final ICompanyService companyService;
    private final IUserService userService;

    @PostMapping("/companies")
    public ResponseEntity<CompanyResponseDto> createCompany(@RequestBody CompanyRequestDto companyRequestDto) {
        return new ResponseEntity<>(companyService.createCompany(companyRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<CompanyResponseDto> updateCompany(@PathVariable Long id,
                                                            @RequestBody CompanyRequestDto companyRequestDto) {
        return ResponseEntity.ok(companyService.updateCompany(id, companyRequestDto));
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<CompanyResponseDto> findCompanyById(@PathVariable long id) {
        return ResponseEntity.ok(companyService.findCompanyById(id));
    }

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyResponseDto>> findAllCompanies() {
        return ResponseEntity.ok(companyService.findAllCompanies());
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userService.createUser(userRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.updateUser(id, userRequestDto));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable long id) {
        return ResponseEntity.ok(userService.findUser(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
