import React, { Component } from 'react'
import ApiServiceShop from '../../service/ApiServiceShop';
import Hander from '../Hader';

class ListShopComponent extends Component{
    constructor(props){
        super(props)
         this.state={
             shop:[],
             message:null
         }

       
        this.reloadShopList=this.reloadShopList.bind(this);
    }

    componentDidMount(){
        this.reloadShopList();
    }
    reloadShopList(){
        ApiServiceShop.fetchShop().then(res=>{
            this.setState({shop:res.data})
            console.log(this.state.shop)

        })
    }

    
    visitShop(shopId,shop) {
        window.localStorage.setItem("shopId", shopId);
        this.props.history.push({ pathname: '/visit-shop',
        state: shop});
    }

     
    render() {
        return (
            <div>
                <Hander/>
                 <br></br>
                 
                 <br></br>
                <h2 className=""></h2>

                <div className="container">
               
                <div className>
                        {
                            this.state.shop.map(
                        shop =>
                            
                       
                        <div className="row g-0">
                      <div className="col-md-4">
                      <img src={"http://localhost:8080/product/image" +`/${shop.imageName}`}  className="img-fluid" alt="..."></img>
                     </div>
                        <div className="col-md-4">
                       <div className="card-body">
                      <h5 className="card-title">Shop Title : {shop.shopName}</h5>
                      <h5 className="card-title">Category : {shop.shopCategory}</h5>
                      <p className="card-text">Shop Description : {shop.shopDescription}</p>
                            <div>
                            <button className="btn btn-success text-center" onClick={() => this.visitShop(shop.s_Id,shop)} style={{marginLeft: '20px'}}> Visit Shop </button>
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

export default ListShopComponent