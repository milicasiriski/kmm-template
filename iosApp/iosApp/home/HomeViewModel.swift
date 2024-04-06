import Foundation
import shared

@MainActor
class HomeViewModel: ObservableObject {
	private let localStorage: LocalStorage = Koin.instance.get(objCProtocol: LocalStorage.self)
	private let getItems: GetItemsUseCase = Koin.instance.get()

	@Published private(set) var user: String = ""
	@Published private(set) var items: [Item] = []
	
	init() {
		// Swift null-check
		if let user = localStorage.getUser() {
			self.user = user
		}
		
		// Or
//		self.user = localStorage.getUser() ?? ""
		
		let result = getItems.invoke()
		if result.isRight {
			items = result.value as! [Item]
		}
	}
}
