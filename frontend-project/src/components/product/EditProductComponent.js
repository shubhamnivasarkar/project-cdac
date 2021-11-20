import React, { Component } from 'react'
import productService from '../../service/product.service';
import VendorManu from '../vendor/VendorManu';


class EditProductCompoent extends Component{

    constructor(props){
        super(props);
         this.state={
            p_Id:'',
            productName:'',
            categories:'',
            stocks:'',
            price:'',
            image:null,
         }
         this.saveProduct = this.saveProduct.bind(this);
         this.loadProduct = this.loadProduct.bind(this);
         this.onFileSelect= this.onFileSelect.bind(this);
    }

    componentDidMount(){
        this.loadProduct();
    }

    onFileSelect(file){
        this.setState({image:file})
    }

    loadProduct(){
       let ProductId=window.localStorage.getItem('productId')
       productService.fetchProductById(ProductId)
       .then((res)=>{
           console.log(res);
           let prod=res.data;
           this.setState({
               p_id:prod.p_Id,
               productName:prod.productName,
               categories:prod.categories,
               stocks:prod.stocks,
               price:prod.price,
               image:prod.imageName,
           })
           console.log(this.state);
       }
      
       )}


       onChange=(e)=>{
        this.setState({[e.target.name]:e.target.value})
    }




     saveProduct=(e)=>{
        e.preventDefault();
        let ProductId=window.localStorage.getItem('productId');
        const formData =new FormData();
        let product={p_Id:this.state.P_Id,productName:this.state.productName,categories:this.state.categories,stocks:this.state.stocks,price:this.state.price}
         formData.append("product",JSON.stringify(product));
         formData.append("image",this.state.image);
       
        console.log(product +" product")
        productService.editProduct(formData,ProductId)
        .then(res=>{
            this.setState({message: 'product added successfully'})
            this.props.history.push('/list-prod');
        })
     }

     render() {
        return(
            <div>


<VendorManu/>
         
          <div className="container">

                <h2 className="text-center">Edit Product</h2>
                <form onSubmit={this.saveProduct}>
                
                <div className="form-group">
                    <label>Product Name:</label>
                    <input type="text" required maxLength="30" placeholder="productName" name="productName" className="form-control" value={this.state.productName} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Categories:</label>
                    <input type="text" required maxLength="30" placeholder="categories" name="categories" className="form-control" value={this.state.categories} onChange={this.onChange}/>
                </div>

               
                
                <div className="form-group">
                    <label>Stock:</label>
                    <input  type="number" required min="1" placeholder="stocks" name="stocks" className="form-control" value={this.state.stocks} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Price:</label>
                    <input  type="number" required min="1" placeholder="price" name="price" className="form-control" value={this.state.price} onChange={this.onChange}/>
                </div>
               
                <div className="col-md-4 Block">
                    
                    <div className="mb-3 productHolder img-responsive text-center">
                        <span className="vertical-aligner"></span>
                        <img src={'..'} class="img-thumbnail img-fluid" alt="New product image here" />
                    </div>
                    <div className="mb-3">
                        <label class="form-label">Add or change image : </label>
                        <input type="file" className="form-control" onChange={e =>this.onFileSelect(e.target.files[0])} multiple={false} />
                    </div>
                    </div>
               

                <button className="btn btn-success" >Save</button>
            </form>
            </div>
    </div>
        );
    }

}

export default EditProductCompoent