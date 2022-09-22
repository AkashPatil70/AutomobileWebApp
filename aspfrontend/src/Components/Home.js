import React, {Component} from 'react';
import { Link ,useNavigate} from 'react-router';


let Home =()=>{

    let navigate=useNavigate();
    return (
      <article>
        <div>
          <section>
            <h1>Automobile servicing platform</h1>
            <hr/>
               <div>
                 <button onClick={()=>{navigate("/Login");}}>Log In</button>
               </div>
               <div>
               <button onClick={()=>{navigate("/registerven");}}>Register as Vendor</button>
               </div>
               <div>
               <button onClick={()=>{navigate("/registercus");}}>Register as Customer</button>
               </div>
          </section>
        </div>
      </article>
    );
  }

export default Home;