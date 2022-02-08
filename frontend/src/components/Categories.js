import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import '../style/Categories.css'
import PropTypes from 'prop-types';

export default class Categories extends Component {
constructor(props){
    super(props);

    this.state = {
        searchValue:''
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.onSearchInputChange = this.onSearchInputChange.bind(this);
};

 
handleSubmit = (e)=>{
      
  e.preventDefault();
 if(this.state.searchValue !== ''){
  this.props.p.history.push('/pacote/'+this.state.searchValue)
 }
}

onSearchInputChange = (e)=>{
  const searchValue = e.target.value;
  console.log(searchValue)
  this.setState({
      searchValue
  });

};


render() {
     const {category} = this.props
    
    return (
    <div>
      <div className="categories-container">
      <h3>Tipos de pacotes</h3>
            <div class="list-group">
                    <Link to={"/"} className={(category=== 'Todos') ?  ("list-group-item active"):("list-group-item")}>Todos</Link>
                    <Link to={"/pacote/3_dias"} className={(category=== '3_dias') ?  ("list-group-item active"):("list-group-item")}>Pacote de 3 dias</Link>   
                    <Link to={"/pacote/10_dias"} className={(category=== '10_dias') ?  ("list-group-item active"):("list-group-item")}>Pacote de 10 dias</Link>
                    <Link to={"/pacote/15_dias"} className={(category=== '15_dias') ?  ("list-group-item active"):("list-group-item")}>pacote de 15 dias</Link>
                    <Link to={"/pacote/30_dias"} className={(category=== '30_dias') ?  ("list-group-item active"):("list-group-item")}>pacote de 30 dias</Link>
            </div>
      </div>
      
      <div className="well blosd">
                <h3 className="lead"> 
                    Pesquisar Pacotes 
                </h3>
                <div className="input-group">
                    <form onSubmit={this.handleSubmit}>
                        <input 
                            type="text"
                            className="form-control"
                            value={this.state.searchValue}    
                            onChange={this.onSearchInputChange}
                        />
                    </form>
                    <span className="input-group-btn" onClick = {this.handleSubmit}>
                        <button className="btn btn-default">
                            <span className="glyphicon glyphicon-search" />
                        </button>
                    </span>
                </div>
            </div>
      </div>
    )
  }
}


Categories.propTypes = {
  category : PropTypes.string
}
