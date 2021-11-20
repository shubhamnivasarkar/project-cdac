
import {Link, useHistory} from "react-router-dom";
const CustomerManu=()=>{

  const history= useHistory();
  const LogoutHandler=(e)=>{
      e.preventDefault();
      history.push('/');
      
  }
 

    return<div>
<nav className="navbar navbar-expand-lg navbar-light bg-light">
  <div className="container">
    <Link to="/home">
        <span className="navbar-brand"><b>Pick N Save Mart</b></span>
    </Link>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div className="navbar-nav">
        <Link to="/home">
        <span className="nav-link active" aria-current="page">Home</span>
        </Link>
        <Link to="/editProfile">
        <span className="nav-link"> Edit Profile</span> 
        </Link>
        <Link to="/updateAddress">
          <span className="nav-link">Update Address</span>
        </Link>
        {/* <Link to="/viewCart">
        <span className="nav-link">Cart</span>
        </Link> */}
        <Link to="/myOrder">
        <span className="nav-link">Orders</span>
        </Link>

        
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </span>
        <div className="logout">
           <button type="button" onClick={LogoutHandler} className="btn btn-danger">
        LogOut
        </button>
        </div>
      </div>
    </div>
  </div>
</nav>


    </div>

}

export default CustomerManu;