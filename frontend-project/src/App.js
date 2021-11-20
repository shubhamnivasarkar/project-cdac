
import './App.css';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom'
import HomeScreen from './screens/HomeScreen';
import ProductsScreen from './screens/ProductsScreen';
import Customer from './screens/Customer';
import LoginPage from './screens/Signin';
import SignUp from './screens/SignupScreen';
import VendorHome from './components/vendor/Vendor';
import ListProductComponent from './components/product/ListProductComponent';
import EditProductCompoent from './components/product/EditProductComponent';
import AddProductComponent from './components/product/AddProductComponent';
import ListShopComponent from './components/shops/ListShopComponent';
import EditShopComponent from './components/shops/EditShopComponent';
import AddShopComponent from './components/shops/AddShopComponent';
import MyShop from './components/shops/MyShop';
import VisitShop from './components/shops/VisitShop';
import ShopAddress from './components/shops/ShopAddress';
import ShopInfoComponent from './components/ShopInfo/ShopInfoComponent';
import PaymentComponent from './components/Payment/paymentComponent';
import EditProfile from './components/EditProfile';
import UpdateAddress from './components/UpdateAddress';
import ViewCart from './components/ViewCart';
import OrderComponent from './components/order/orderComponent';
import EditCartComponent from './components/cart/EditCartComponent';



function App() {
  return (
    <div className="App">
      <div className="parent">
        <Router> 
          <Switch>
          <div className="container">
           <Route path="/home" component={HomeScreen}></Route>
          <Route path="/products" component={ProductsScreen}></Route>
          <Route path="/shops" component={ListShopComponent}></Route>
           <Route path="/myProfile" component={Customer}></Route>
          <Route path="/" component={LoginPage} exact />
          <Route path="/signup" component={SignUp} />
          <Route path="/vendor" component={VendorHome} />
          <Route path="/add-shop" component={AddShopComponent}/>
          <Route path="/list-shop" component={ListShopComponent}/>
          <Route path="/edit-shop" component={EditShopComponent}/>
          <Route path="/add-prod" component={AddProductComponent}/>
          <Route path="/list-prod" component={ListProductComponent}/>
          <Route path="/edit-prod" component={EditProductCompoent}/>
          <Route path="/shop" component={MyShop} />
          <Route path="/visit-shop" component={VisitShop}/>
          <Route path="/shopAddress" component={ShopAddress}/>
          <Route path="/shopOrderDetails" component={ShopInfoComponent} />      
         <Route path="/editProfile" component={EditProfile} exact></Route>
         <Route path="/updateAddress" component={UpdateAddress} exact></Route>
         <Route path="/viewCart" component={ViewCart} exact></Route>
         <Route path="/myOrder" component={OrderComponent}></Route>
         <Route path="/edit-cart" component={EditCartComponent}/>
         <Route path="/payment" component={PaymentComponent}/>
    
          
    </div>
    </Switch>
    </Router>
    </div>
    </div>
  );
}

export default App;
