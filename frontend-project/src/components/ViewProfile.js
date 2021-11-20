import { useEffect, useState } from "react";
import UserService from "../api/user.service"





const ViewProfile=()=>{

    const [user,setUser]=useState('');
    const [address,setAddress]=useState('');

 
    const loadUserInfo=()=>{
    UserService.getPublicContent().then(Response =>{
           setUser(Response.data)
    },error =>{
        console.log("got error");
    })
    }

    const loadAddress=()=>{
        UserService.getAddress()
        .then(res=>{
           setAddress(res.data)
        },err=>{
            console.log("got error  "+err );
        })
    }

    useEffect(()=>{
        loadUserInfo();
        loadAddress();

    },[])

    return<div className="container">
         <img src="images/picknsave.jpg" height="550px" width="850"></img>
        <h3>Name      : {user.firstName} {user.lastName} </h3>
        <h4>Email     : {user.email} </h4>
        
        <h4>Address   : {address.addressLine1} </h4>
        <h4>Address2  :{address.addressLine2}</h4>
        <h4>City      : {address.city}</h4>
        <h4>PinCode   :{address.pinCode}</h4>
    </div>
}

export default ViewProfile;