import React,{ Component } from "react";
import { Link } from "react-router-dom";
import authService from "../../api/auth.service";



class VendorManu extends Component{    

    constructor(props){
        super(props)
        this.state={
            state:''
        }
       
    }

    render(){
        return <div>

<nav className="navbar navbar-expand-lg navbar-light bg-light">
  <div className="container-fluid">
    <Link to="/vendor">
        <span className="navbar-brand" ><b>Pick N Save Mart</b></span>
    </Link>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div className="navbar-nav">
        <Link to="/vendor">
        <span className="nav-link active" aria-current="page">Home</span>
        </Link>
        <Link to="/shop">
        <span className="nav-link">My Shop</span>
        </Link>
        <Link to="/list-prod">
          <span className="nav-link">Add Products</span>
        </Link>
        <Link to="/shopAddress">
        <span className="nav-link">Update Address</span>
        </Link>
        <Link to="/shopOrderDetails">
        <span className="nav-link">Order Details</span>
        </Link>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <div class="col-12">
        
        <span>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </span>
        <Link to="/">
        <button type="button" class="btn btn-success btn-lg float-right" className="btn btn-danger mr-5 float-right">
        LogOut
        </button>
        </Link>
        </div>
        </div>
      </div>
    </div>
  </div>
</nav>


        </div>
    }
   


}
export default VendorManu;