import './App.css';
import { useEffect, useState } from 'react';
import ChallengeList from './components/ChallengeList'
import axios from 'axios';
function App() {
  
    const [challenges, setChallenges] = useState([]);
    useEffect(() =>{
      const fetchChallenge = async () => {
        const response = await axios.get('http://localhost:8080/challenges')
        setChallenges(response.data)
      };
      fetchChallenge();

    }, [])
 return (
    <div className="App">
      <h1>Monthly Challenege</h1>
      <ChallengeList challenges={challenges}/>
    </div>
  );
}

export default App;
