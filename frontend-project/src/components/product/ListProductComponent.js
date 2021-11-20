import React, { Component } from 'react'
import cartService from '../../service/cart.service';
import productService from '../../service/product.service';
import VendorManu from '../vendor/VendorManu';

class ListProductComponent extends Component{
    constructor(props){
        super(props)
         this.state={
             product:[],
             message:null
         }

         this.deleteProduct = this.deleteProduct.bind(this);
         this.editProduct = this.editProduct.bind(this);
         this.addProduct = this.addProduct.bind(this);
         this.reloadProductList = this.reloadProductList.bind(this);
    }

    componentDidMount(){
        this.reloadProductList();
    }

    reloadProductList(){
         productService.fetchProduct().then(res=>{
             this.setState({product:res.data})
             console.log(res)
            console.log(this.state.product)

        },err=>{
            console.log(err);
        })
    }


    deleteProduct(productId){
        console.log(productId)
        productService.deleteProduct(productId)
        .then(res=>{
            this.setState({message:'product deleted successfully'})
            this.setState({product:this.state.product.filter(product=>product.productId!==productId)})
                this.reloadProductList();
        })
    }

    editProduct(productId){
        window.localStorage.setItem("productId",productId)
        this.props.history.push('/edit-prod');
    }
  
     addProduct(){
        window.localStorage.removeItem("productId");
        this.props.history.push('/add-prod');
     }
    
     addProductToCart(productId){
         let pro_id=productId;
         cartService.addCart(pro_id)
         .then(res=>{
             console.log(res);
            this.props.history.push('/list-prod');
         },err=>{
             console.log(err);
         })
     }

     render() {
        return <div>
        <VendorManu/>
         
          <div className="container">
                <h2 className="text-center">Product Details</h2>
                <button className="btn btn-danger" style={{width:'100px'}} onClick={() => this.addProduct()}> Add Product</button>
                <div className="row row-cols-1 row-cols-md-3 g-4">
                {
                this.state.product.map(
                        product => <div className="col">
                        <div className="card h-100 CardElement">
                       <div className="card-body text-center">
                               <img src={"http://localhost:8080/product/image" +`/${product.imageName}`} alt="product image" className="img-fluid"/>
                           <div className="card-title"> <h3>{product.productName}</h3> </div>
                           <div className="card-text">
                               <h6>category : {product.categories}  stockes : {product.stocks}</h6>
                               <h5>{product.price} &#8377;  </h5>
                               <hr/>
                               <div className="row">
                               <button className="btn btn-success" onClick={() => this.deleteProduct(product.p_Id)}> Delete</button>
                                <button className="btn btn-primary" onClick={() => this.editProduct(product.p_Id)} > Edit</button>
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

}
}
export default ListProductComponent;