package com.example.lab10

class Post {

    var name:String?=null
    var desc:String?=null
    var id:String?=null

    constructor(name:String,desc:String,i:String){
        this.name=name
        this.desc=desc
        this.id=i

    }

    fun setI(i:String){
        this.id=i
    }

    override fun toString(): String {
        return "Post(name=$name, desc=$desc)"
    }


}