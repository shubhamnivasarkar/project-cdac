import React,{ Component } from "react"
import UserService from "../api/user.service"
import CustomerManu from "../CustomerManu";

class UpdateAddress extends Component{

    constructor(){
        super();
        this.state={
            addressLine1:"",
            addressLine2:"",
            city:"",
            pinCode:"",
            state:"",
            country:"",
            id:"",
        }
        this.saveUser=this.saveUser.bind(this);

    }
   


    onchange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

        saveUser = (e) => {
            e.preventDefault();
            let newAddress = {id: this.state.id, addressLine1: this.state.addressLine1, addressLine2: this.state.addressLine2, city: this.state.city, pinCode: this.state.pinCode, state: this.state.state,country:this.state.country};
           UserService.addEditAddress(newAddress)
                .then(res => {
                    this.setState({message : 'User added successfully.'});
                    this.props.history.push('/ViewProfile');
                });
        }

    render(){
        return<div>
            <CustomerManu />
            <form onSubmit={this.saveUser}>
        <h2 className="text-center">update_Address</h2>
            <div className="form-group">
                <label>addressLine1:</label>
                <input placeholder="addressLine1" required maxLength="30" name="addressLine1" className="form-control"  onChange={this.onchange}/>
            </div>

            <div className="form-group">
                <label>addressLine2:</label>
                <input placeholder="addressLine2" maxLength="30" name="addressLine2" className="form-control"  onChange={this.onchange}/>
            </div>

            <div className="form-group">
                <label>city:</label>
                <input placeholder="city" name="city" required maxLength="30" className="form-control"  onChange={this.onchange}/>
            </div>

            <div className="form-group">
                <label>pinCode</label>
                <input type="text" pattern="[0-9]{6}"title="pincode should only contain  6 digit number " maxLength="6" placeholder="pinCode" name="pinCode" className="form-control"  onChange={this.onchange}/>
            </div>

            <button className="btn btn-success">Save</button>
        </form>
    </div>
    }
}

export default UpdateAddress;