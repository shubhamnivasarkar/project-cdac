import {Link} from 'react-router-dom'
import authService from "../api/auth.service";
import {useHistory} from 'react-router-dom'




const Hander=(props)=>{

  const history= useHistory();
  const LogoutHandler=(e)=>{
      e.preventDefault();
      authService.logout();
      history.push('/');
      
  }

  const UserCheck=()=>{
    
    history.push('/myProfile')
  }

    return <div>
<nav className="navbar navbar-expand-lg navbar-light bg-light">
  <div className="container-fluid">
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
        <Link to="/shops">
        <span className="nav-link">Shops</span>
        </Link>
        <Link to="/products">
          <span className="nav-link">Products</span>
        </Link>
       <span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       </span>
        <div className="Myprofile">
        <button type="button" onClick={UserCheck} className="btn btn-success">
        MyProfile
        </button>
        </div>
        <div className="cart">
        <Link to="/viewCart">
        <button type="button" className="btn btn-primary">
        Cart <span className="badge bg-secondary"></span>
        </button>
        </Link>
        </div>
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

export default Hander;