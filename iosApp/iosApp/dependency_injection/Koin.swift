import Foundation
import shared

final class Koin {
	private(set) var core: Koin_coreKoin?
	static let instance = Koin()
	
	private init() {}
	
	static func start() {
		if instance.core == nil {
			let app = KoinIOS.shared.initialize(
				createKeyValueStore: createKeyValueStore
			)
			instance.core = app.koin
		}
		
		if instance.core == nil {
			fatalError("Can't initialize Koin.")
		}
	}
	
	func get<T: AnyObject>() -> T {
		guard let core = core else {
			fatalError("You should call `start()` before using (#function)")
		}
		
		guard let result = core.get(objCClass: T.self) as? T else {
			fatalError("Koin can't provide an instance of type: (T.self)")
		}
		
		return result
	}
	
	func get<T: AnyObject>(parameter: String) -> T {
		guard let core = core else {
			fatalError("You should call `start()` before using (#function)")
		}
		
		guard let result = core.get(objCClass: T.self, parameter: parameter) as? T else {
			fatalError("Koin can't provide an instance of type: (T.self)")
		}
		
		return result
	}
	
	func get<T: AnyObject>(objCProtocol: Protocol) -> T {
		guard let core = core else {
			fatalError("You should call `start()` before using (#function)")
		}
		
		guard let result = core.get(objCProtocol: objCProtocol) as? T else {
			fatalError("Koin can't provide an instance of type: (T.self)")
		}
		
		return result
	}
	
	func get<T: AnyObject>(objCProtocol: Protocol, parameter: String) -> T {
		guard let core = core else {
			fatalError("You should call `start()` before using (#function)")
		}
		
		guard let result = core.get(objCProtocol: objCProtocol, parameter: parameter) as? T else {
			fatalError("Koin can't provide an instance of type: (T.self)")
		}
		
		return result
	}
}

private func createKeyValueStore() -> KeyValueStore {
	return UserDefaultsStore()
}
