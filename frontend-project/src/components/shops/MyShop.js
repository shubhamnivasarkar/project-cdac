import React, { Component } from "react";
import ApiServiceShop from "../../service/ApiServiceShop";
import VendorManu from "../vendor/VendorManu";


class MyShop extends Component {

    constructor() {
        super();
        this.state = {
            shop: ''
        }

        this.loadShop = this.loadShop.bind(this);
        this.deleteShop = this.deleteShop.bind(this);
        this.editShop = this.editShop.bind(this);
        this.addShop = this.addShop.bind(this);
    }

    componentDidMount() {
        this.loadShop();
    }

    loadShop() {
        ApiServiceShop.fetchShopById()
            .then(res => {
                this.setState({ shop: res.data })
                console.log(res.data);
            }, err => {
                console.log(err);
            })
    }

    addShop() {
        window.localStorage.removeItem("shopId");
        this.props.history.push('/add-shop');
    }

    deleteShop(shopId) {
        console.log(shopId)
        ApiServiceShop.deleteShop(shopId)
            .then(res => {
                this.setState({ message: 'Shop deleted successfully' });
                //this.setState({shop:this.state.shop.filter(shop=>shop.shopId!==shopId)})
                this.loadShop();
            })
    }
    editShop(shopId) {
        window.localStorage.setItem("shopId", shopId);
        this.props.history.push('/edit-shop');
    }

    render() {
        return <div>
            <VendorManu />

            <div className="container">
                {!this.state.shop && <div>  <button className="btn btn-danger" style={{ width: '100px' }} onClick={() => this.addShop()}> Add Shop</button> </div>}

                {this.state.shop && 
                <div>
                    {

                        <div className="row g-0">
                            <div className="col-md-4">
                                <img src={"http://localhost:8080/product/image" + `/${this.state.shop.imageName}`} className="img-fluid" alt="..."></img>
                            </div>
                            <div className="col-md-8">
                                <div className="card-body">
                                    <h5 className="card-title">Shop Title : {this.state.shop.shopName}</h5>
                                   
                                    <h5 className="card-title">Category : {this.state.shop.shopCategory}</h5>
                                    <h5 className="card-text">Shop Description : {this.state.shop.shopDescription}</h5>
                                    
                                    <div>
                                        <button className="btn btn-success" onClick={() => this.deleteShop(this.state.shop.s_Id)}> Delete</button>
                                        <button className="btn btn-success" onClick={() => this.editShop(this.state.shop.s_Id)} style={{ marginLeft: '20px' }}> Edit</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                    }
                </div>
                }

            </div>

        </div>

    }

}

export default MyShop;