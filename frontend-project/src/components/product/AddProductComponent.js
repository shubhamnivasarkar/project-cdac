import React, { Component } from 'react'
import productService from '../../service/product.service';
import VendorManu from '../vendor/VendorManu';
class AddProductComponent extends Component{
    constructor(props){
        super(props);
        this.state={
            P_Id:'',
            productName:'',
            categories:'',
            stocks:'',
            price:'',
            image:null,
            fileimage:null,


        }

        this.onFileSelect=this.onFileSelect.bind(this);
    }

    saveProduct=(e)=>{
        e.preventDefault();
        const formData =new FormData()
        let product={p_Id:this.state.P_Id,productName:this.state.productName,categories:this.state.categories,stocks:this.state.stocks,price:this.state.price}
         formData.append("newProduct",JSON.stringify(product));
         formData.append("image",this.state.image);
        productService.addProduct(formData)
        .then(res=>{
            this.setState({message:"product added successfully."})
            this.props.history.push('/list-prod')
        },err=>{
            console.log(err);
        }) 
    }
    onChange=(e)=>
          this.setState({ [e.target.name]: e.target.value });

           


          onFileSelect(file){
              this.setState({image:file})
          }

          render() {
            return(
                <div>
                  
                  <VendorManu/>
         
          <div className="container">

                    <h2 className="text-center">Add Product</h2>
                    <form onSubmit={this.saveProduct}>
                    <div className="form-group">
                        <label>Product Name:</label>
                        <input type="text" required maxLength="30" placeholder="Enter Product Name" name="productName" className="form-control" value={this.state.productName} onChange={this.onChange}/>
                    </div>
    
                    <div className="form-group">
                        <label>Categories:</label>
                        <input type="text" required maxLength="30" placeholder="Enter category" name="categories" className="form-control" value={this.state.categories} onChange={this.onChange}/>
                    </div>
    
                   
                    
                    <div className="form-group">
                        <label>Stock:</label>
                        <input  type="number" required min="0" placeholder="Enter stocks" name="stocks" className="form-control" value={this.state.stocks} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Price:</label>
                        <input  type="number" required min="1" title="minimum price 1 ruppee" placeholder="Enter price" name="price" className="form-control" value={this.state.price} onChange={this.onChange}/>
                    </div>

                    <div className="col-md-4 Block">
                    
                    <div className="mb-3 productHolder img-responsive text-center">
                        <span className="vertical-aligner"></span>
                        <img src={this.state.fileimage} className="img-fluid"  />
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

 export default  AddProductComponent;
