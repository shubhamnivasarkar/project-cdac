import React, { Component } from 'react'
import ApiServiceShop from '../../service/ApiServiceShop';
import VendorManu from '../vendor/VendorManu';

class AddShopComponent extends Component{
    constructor(props){
        super(props);
        this.state={
            shopName:'',
            shopDescription:'',
            shopCategory:'',
            image:null,


        }
    }
     saveShop=(e)=>{
        e.preventDefault();
        const formData =new FormData();
        let shop={shopName:this.state.shopName,shopDescription:this.state.shopDescription,shopCategory:this.state.shopCategory}
         formData.append("newShop",JSON.stringify(shop));
         formData.append("image",this.state.image);
        
     ApiServiceShop.addShop(formData)
     .then(res=>{
         this.setState({message:"shop added successfully."})
         this.props.history.push('/shop')
     }) 
    }


    onFileSelect(file){
        this.setState({image:file})
    }

    onChange=(e)=>
          this.setState({ [e.target.name]: e.target.value });

    render() {
        return(
            <div>
                <VendorManu/>
                 
                <div>
                <h2 className="text-center">Add Shop</h2>
                <form onSubmit={this.saveShop}>
                <div className="form-group">
                    <label>Shop Name:</label>
                    <input type="text" required maxLength="30" placeholder="Enter Shop Name" name="shopName" className="form-control" value={this.state.shopName} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Shop Description:</label>
                    <input type="text" required maxLength="30" placeholder="Enter Shop Description" name="shopDescription" className="form-control" value={this.state.shopDescription} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Shop Category:</label>
                    <input  type="text" required maxLength="30" placeholder="Enter Shop Category" name="shopCategory" className="form-control" value={this.state.shopCategory} onChange={this.onChange}/>
                </div>

                <div className="col-md-4 Block">
                    
                    <div className="mb-3 productHolder img-responsive text-center">
                        <span className="vertical-aligner"></span>
                        <img src={this.state.fileimage} class="img-fluid" />
                    </div>
                    <div className="mb-3">
                        <label class="form-label">Add Image : </label>
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
export default AddShopComponent
