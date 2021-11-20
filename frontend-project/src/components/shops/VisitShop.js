import React,{ Component } from "react";
import ApiServiceShop from '../../service/ApiServiceShop'
import cartService from "../../service/cart.service";
import Hander from "../Hader";


class VisitShop extends Component{

    constructor(props){
        super(props);

        this.state={
            product:[]
        }

        this.reloadProductsList=this.reloadProductsList.bind(this);
    }

 componentDidMount(){
   this.reloadProductsList();
 }

 reloadProductsList(){
     let Sid=window.localStorage.getItem('shopId')
    ApiServiceShop.visitShop(Sid).then(res=>{
        this.setState({product:res.data})
        console.log(res)
        console.log(this.state.product)
    },err=>{
        console.log(err);
    })
}




addProductToCart(productId){
    let pro_id=productId;
    cartService.addCart(pro_id)
    .then(res=>{
        console.log(res);
       this.reloadProductsList();
       alert("Item Added To Cart")
    },err=>{
        console.log(err);
    })
}

render() {
    const { state } = this.props.location
   return (
       <div>
   <Hander/>
    
     <div className="container">
           <h2 className="text-center">Shop Name: {state.shopName} </h2>
           <h4 className="text-center">Owner Name: {state.user.firstName} {state.user.lastName}</h4>
           <div className="row row-cols-1 row-cols-md-3 g-4">
           {
                            this.state.product.map(
                        product => <div className="col">
                        <div className="card h-100 CardElement">
                       <div className="card-body text-center">
                            <img src={"http://localhost:8080/product/image" +`/${product.imageName}`} alt="product image" className="img-fluid"/>
                           <div className="card-title"> <h3>{product.productName}</h3> </div>
                           <div className="card-text">
                               <h6>category : {product.categories}</h6>
                               <h5>{product.price} &#8377; </h5>
                               <hr/>
                               <div className="row">
                                   <div className="col-md-4 Block"><button onClick={() => this.addProductToCart(product.p_Id)} className="btn btn-primary">Add to cart</button></div>
                               </div>
                           
                           </div>
                       </div>
                   </div>
                   </div>

                        
                            )
                        }
           </div>
      </div>
       </div>
   );
}

}

export default VisitShop;