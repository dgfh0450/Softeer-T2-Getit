import "./App.css";
import Button from "./components/customButton";
import Input from "./components/customInput";
import LandingButton from "./components/landingButton";
import useModal from "./hooks/useModal";
import Map from "./component/Map";

function App() {
	const [FailModal, isFailOpen, openFail, closeFail] = useModal();
	const [SuccessModal, isSuccessOpen, openSuccess, closeSuccess] = useModal();

	return (
		<>
			<div>
				<div className="w-1/3 flex flex-col justify-start space-y-5 p-5 mb-5 rounded-sm border border-dashed border-[#9747FF] ">
					<Button onClick={openFail}>버튼</Button>
					<Button onClick={openSuccess} variant="secondary">
						버튼
					</Button>
					<Button variant="disabled">버튼</Button>

					<LandingButton />
				</div>

				<div className="w-1/3 rounded-sm border border-dashed border-[#9747FF] flex flex-col justify-start space-y-5 p-5">
					<Input
						placeholder="우리 학교를 검색해보세요"
						handleVoiceInput={() => { }}
						onLengthChange={(e: string) => {
							console.log(e);
						}}
					/>
				</div>
				<SuccessModal>
					<p className="text-kor-body1 font-bold text-primary-500">불편한 길 제보가 완료되었습니다!</p>
					<div className="space-y-0">
						<p className="text-kor-body3 font-regular text-gray-700">제보해주셔서 감사합니다.</p>
						<p className="text-kor-body3 font-regular text-gray-700">
							관리자 검토 후 반영되니 조금만 기다려주세요.
						</p>
					</div>
				</SuccessModal>
				<FailModal>
					<p className="text-kor-body1 font-bold text-system-red">경로를 찾을 수 없습니다</p>
					<div className="space-y-0">
						<p className="text-kor-body3 font-regular text-gray-700">
							해당 경로에는 배리어프리한 길이 없습니다.
						</p>
						<p className="text-kor-body3 font-regular text-gray-700">다른 건물을 시도해주세요.</p>
					</div>
				</FailModal>
			</div>
			<div className="h-[500px] w-[500px]">
				<Map />
			</div>
			<p className="read-the-docs">Click on the Vite and React logos to learn more</p>
		</>
	);
}

export default App;
