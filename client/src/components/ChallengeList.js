import Challenege from "./Challenge";
function ChallengeList({challenges}) {
    return(
        <div className="list-group">
            {challenges.map(challenge =>(
                <Challenege key={challenge.id}
                challenge={challenge}/>
            ))}
        </div>
    );
}

export default ChallengeList