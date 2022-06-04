import React from 'react'

const Logo = (props) => {
    return (
        <div className={`${props.className}`}>
            <svg width="100" height="100" viewBox="0 0 100 100" fill="none" xmlns="http://www.w3.org/2000/svg">
                <rect x="100" y="100" width="50" height="50" transform="rotate(-180 100 100)" fill="url(#paint0_linear_10_2)" />
                <rect width="50" height="50" fill="url(#paint1_linear_10_2)" />
                <rect x="13" y="88" width="75" height="75" transform="rotate(-90 13 88)" fill="url(#paint2_diamond_10_2)" fill-opacity="0.63" />
                <path d="M23.5664 25.9102L21.6743 25.6294V24.5918H29.5112C32.742 24.5918 35.2567 25.3812 37.0552 26.96C38.813 28.5144 39.6919 30.6424 39.6919 33.3443C39.6919 35.2893 39.2402 37.0267 38.3369 38.5567C37.5068 39.9645 36.3553 41.0632 34.8823 41.8526C33.45 42.6175 31.9079 43 30.2559 43H21.6743V41.9624L23.5664 41.6817V25.9102ZM25.8247 26.0689V41.5352H30.2314C32.2741 41.5352 33.9668 40.8923 35.3096 39.6065C36.693 38.2637 37.3848 36.51 37.3848 34.3452C37.3848 30.203 35.9362 27.6192 33.0391 26.5938C32.0381 26.2438 30.8418 26.0689 29.4502 26.0689H25.8247Z" fill="white" />
                <path d="M66.0728 57.5918V58.6294L64.2417 58.9102V74.5352H70.9312L71.6514 71.8008H72.6523L72.5425 76H60.0913V74.9624L61.9468 74.6816V58.9102L60.0913 58.6294V57.5918H66.0728Z" fill="white" />
                <defs>
                    <linearGradient id="paint0_linear_10_2" x1="160" y1="158.5" x2="99.5" y2="99" gradientUnits="userSpaceOnUse">
                        <stop stop-color="#C1121F" />
                        <stop offset="1" stop-color="#C1121F" stop-opacity="0" />
                    </linearGradient>
                    <linearGradient id="paint1_linear_10_2" x1="60" y1="58.5" x2="-0.500001" y2="-0.999998" gradientUnits="userSpaceOnUse">
                        <stop stop-color="#C1121F" />
                        <stop offset="1" stop-color="#C1121F" stop-opacity="0" />
                    </linearGradient>
                    <radialGradient id="paint2_diamond_10_2" cx="0" cy="0" r="1" gradientUnits="userSpaceOnUse" gradientTransform="translate(50.5 125.5) rotate(45) scale(53.033)">
                        <stop stop-color="#C1121F" />
                        <stop offset="0.546875" stop-color="#C1121F" stop-opacity="0.420168" />
                        <stop offset="0.822917" stop-color="#C1121F" stop-opacity="0" />
                        <stop offset="0.989583" stop-color="#C1121F" stop-opacity="0" />
                    </radialGradient>
                </defs>
            </svg>


        </div>
    )
}

export default Logo