
package com.example.UserRepository

import com.example.JpaRepository
import org.springframework.data.jpa.repository.JpaRepository

/

@Repository
interface UserRepository <User, Long > {  
    var  findByEmail(email: String?): User
}




