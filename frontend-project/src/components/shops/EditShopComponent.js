import React, { Component } from 'react'
import ApiServiceShop from '../../service/ApiServiceShop';
import VendorManu from '../vendor/VendorManu';

class EditShopComponent extends Component{
    constructor(props){
        super(props);
         this.state={
            s_Id:'',
            shopName:'',
            shopDescription:'',
            shopCategory:'',
            user:{},
            image:null,
         }
         this.saveShop = this.saveShop.bind(this);
         this.loadShop = this.loadShop.bind(this);
         this.onFileSelect = this.onFileSelect.bind(this);
    }

    componentDidMount(){
        this.loadShop();
    }

    onFileSelect(file){
        this.setState({image:file})
    }

    loadShop(){
        ApiServiceShop.fetchShopById()
        .then((res)=>{
            console.log(res);
            let shop=res.data;
            this.setState({
                s_Id:shop.s_Id,
                shopName:shop.shopName,
                shopDescription:shop.shopDescription,
                shopCategory:shop.shopCategory,
                user:shop.user,
                image:shop.imageName,
            })

            console.log(this.state);
        })
    }
    
    onChange=(e)=>{
        this.setState({[e.target.name]:e.target.value})
    }

   

    saveShop=(e)=>{
        e.preventDefault();
        const formData =new FormData();
        let shop={s_Id:this.state.s_Id,shopName:this.state.shopName,shopDescription:this.state.shopDescription,shopCategory:this.state.shopCategory}
         formData.append("shop",JSON.stringify(shop));
         formData.append("image",this.state.image);
        
         console.log(shop)
        ApiServiceShop.editShop(formData)
       .then(res=>{
           this.setState({message: 'shop added successfully'})
           this.props.history.push('/shop');
       })
    }
    render() {
        return(
            <div>
                <VendorManu/>
          
                <h2 className="text-center">Edit Shop</h2>
                <form onSubmit={this.saveShop}>
                <div className="form-group">
                    <label>Shop Name:</label>
                    <input type="text" required maxLength="30" placeholder="shopName" name="shopName" className="form-control" value={this.state.shopName} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Shop Description:</label>
                    <input type="text" required maxLength="30" placeholder="shopDescription" name="shopDescription" className="form-control" value={this.state.shopDescription} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Shop Category:</label>
                    <input  type="text" required maxLength="30" placeholder="shopCategory" name="shopCategory" className="form-control" value={this.state.shopCategory} onChange={this.onChange}/>
                </div>


                <div className="col-md-4 Block">
                    
                    {/* <div className="mb-3 productHolder img-responsive text-center">
                        <span className="vertical-aligner"></span>
                        <img src={this.state.imageName} class="img-thumbnail img-fluid" alt="New shop image here" />
                    </div> */}
                    <div className="mb-3">
                        <label class="form-label">Add or change image : </label>
                        <input type="file" className="form-control" onChange={e =>this.onFileSelect(e.target.files[0])} multiple={false} />
                    </div>
                    </div>
               

                <button className="btn btn-success" >Save</button>
            </form>
    </div>
        );
    }
}

export default EditShopComponent