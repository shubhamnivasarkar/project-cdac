import React, { Component } from 'react'
import cartService from '../../service/cart.service';

class EditCartComponent extends Component{

    constructor(props){
        super(props);
         this.state={
            cartId:'',
            quantity:'',
            product:'',
         }
         this.saveCart = this.saveCart.bind(this);
         this.loadCart = this.loadCart.bind(this);
    }

    componentDidMount(){
        this.loadCart();
    }
    loadCart(){
        let cId=window.localStorage.getItem('cartId')
        cartService.fetchCartById(cId)
        .then((res)=>{
            let cart=res.data;
            this.setState({
                cartId:cart.cartId,
                quantity:cart.quantity,
                product:cart.product.productName,
               
            })
            console.log(this.state);
        })    
    }

    onChange=(e)=>{
        this.setState({[e.target.name]:e.target.value})
    }

    saveCart=(e)=>{
        e.preventDefault();
        let cId=window.localStorage.getItem('cartId')
        let cart={cartId:this.state.cartId,quantity:this.state.quantity}
        console.log(cart +" cart")
        cartService.editCart(cId,cart)
        .then(res=>{
            this.setState({message: 'cart updated successfully'})
            this.props.history.push('/viewCart');
        })
     }


     render() {
       
        return(
            <div>
               
                <h2 className="text-center">Edit Quantity</h2>
                <form onSubmit={this.saveCart}>
                

                <div className="form-group">
                    <label>ProductName:</label>
                    <input type="text"  placeholder="product" name="product" className="form-control" readOnly="true" value={this.state.product} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Quantity:</label>
                    <input type="number" required min="1" placeholder="quantity" name="quantity" className="form-control" value={this.state.quantity} onChange={this.onChange}/>
                </div>

                <button className="btn btn-success" >Save</button>
            </form>
    </div>
        );
    }

}

export default EditCartComponent
