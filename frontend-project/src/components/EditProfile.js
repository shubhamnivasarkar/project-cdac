
import React, { Component } from 'react'
import UserService from '../api/user.service'
import CustomerManu from './CustomerManu';


class EditProfile extends Component{

    constructor(props){
        super(props);
            this.state={
                id:'',
                firstName: '',
                lastName: '',
                email:'',
                phone:'',
                role:'',
            }

        this.saveUser = this.saveUser.bind(this);
        this.loadUser = this.loadUser.bind(this);
            
        }

        componentDidMount() {
            this.loadUser();
        }

    
        loadUser=()=>{
            UserService.getPublicContent()
                .then((res) => {
                    let user = res.data;
                    this.setState({
                        id:user.id,
                        firstName:user.firstName,
                        lastName:user.lastName,
                        email:user.email,
                        phone:user.phone,
                        role:user.role,

                    })
                });
        }

        onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

        saveUser = (e) => {
            e.preventDefault();
            let user = {id: this.state.id, firstName: this.state.firstName, lastName: this.state.lastName, email: this.state.email, phone: this.state.phone,role:this.state.role};
            UserService.Editprofile(user.id,user)
                .then(res => {
                    this.setState({message : 'User added successfully.'});
                    this.props.history.push('/myProfile');
                });
        }


        render() {
            return (
                <div>
                     <CustomerManu/>
                    <h2 className="text-center">Edit Profile</h2>
                    <form>
    
                        <div className="form-group">
                            <label>Email:</label>
                            <input type="email" placeholder="email" name="email" className="form-control" readonly="true" defaultValue={this.state.email}/>
                        </div>
    
                        <div className="form-group">
                            <label>First Name:</label>
                            <input placeholder="First Name" name="firstName" className="form-control" value={this.state.firstName} onChange={this.onChange}/>
                        </div>
    
                        <div className="form-group">
                            <label>Last Name:</label>
                            <input placeholder="Last name" name="lastName" className="form-control" value={this.state.lastName} onChange={this.onChange}/>
                        </div>
    
                        <div className="form-group">
                            <label>Phone</label>
                            <input type="text" placeholder="phone" name="phone" className="form-control" value={this.state.phone} onChange={this.onChange}/>
                        </div>
    
                        <button className="btn btn-success" onClick={this.saveUser}>Save</button>
                    </form>
                </div>
            );
        }



    }
export default  EditProfile;