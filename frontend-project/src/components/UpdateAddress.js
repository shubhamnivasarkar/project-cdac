import React,{ Component } from "react"
import UserService from "../api/user.service"
import CustomerManu from "./CustomerManu";

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
                    this.props.history.push('/myProfile');
                });
        }

    render(){
        return<div>
            <CustomerManu/>
            <form onSubmit={this.saveUser}>
        <h2 className="text-center">Update Address</h2>
            <div className="form-group">
                <label>Address Line 1:</label>
                <input placeholder="Enter your address" required maxLength="45" name="addressLine1" className="form-control"  onChange={this.onchange}/>
            </div>

            <div className="form-group">
                <label>Address Line 2:</label>
                <input placeholder="Enter your address" maxLength="45" name="addressLine2" className="form-control"  onChange={this.onchange}/>
            </div>

            <div className="form-group">
                <label>City:</label>
                <input placeholder="Enter city" name="city" required maxLength="45" className="form-control"  onChange={this.onchange}/>
            </div>

            <div className="form-group">
                <label>Pin Code:</label>
                <input type="text" placeholder="Enter Pin Code" required pattern="[0-9]{6}"title="pincode should only contain  6 digit number " name="pinCode" className="form-control"  onChange={this.onchange}/>
            </div>

            <button className="btn btn-success" >Save</button>
        </form>
    </div>
    }
}

export default UpdateAddress;